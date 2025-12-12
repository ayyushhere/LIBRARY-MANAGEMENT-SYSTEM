const API_URL = '/api/books';

document.addEventListener('DOMContentLoaded', () => {
    
    // --- 1. Login Logic ---
    const loginForm = document.getElementById('login-form');
    if (loginForm) {
        loginForm.addEventListener('submit', (e) => {
            e.preventDefault();
            const password = document.getElementById('password').value;
            // Simple client-side auth for demo
            if (password === 'admin') {
                localStorage.setItem('admin_session', 'true');
                window.location.href = 'admin.html';
            } else {
                alert('Access Denied: Incorrect Password');
            }
        });
    }

    // --- 2. Admin Logic ---
    if (document.body.id === 'admin-page') {
        // Auth Check
        if (!localStorage.getItem('admin_session')) {
            window.location.href = 'login.html';
            return;
        }

        // Logout
        document.getElementById('logout-btn').addEventListener('click', () => {
            localStorage.removeItem('admin_session');
            window.location.href = 'index.html';
        });

        // Add Book
        const addBookForm = document.getElementById('add-book-form');
        if (addBookForm) {
            addBookForm.addEventListener('submit', (e) => {
                e.preventDefault();
                const name = document.getElementById('book-name').value;
                const author = document.getElementById('book-author').value;
                
                fetch(API_URL, {
                    method: 'POST',
                    headers: { 'Content-Type': 'application/json' },
                    body: JSON.stringify({ name, author })
                })
                .then(res => res.json())
                .then(() => {
                    document.getElementById('book-name').value = '';
                    document.getElementById('book-author').value = '';
                    fetchBooks(true); // REfresh admin table
                })
                .catch(err => console.error(err));
            });
        }

        // Initial Load for Admin
        fetchBooks(true);
    }

    // --- 3. Public Logic ---
    if (document.body.id === 'public-page') {
        const searchInput = document.getElementById('search-input');
        if (searchInput) {
            searchInput.addEventListener('input', (e) => {
                const term = e.target.value.toLowerCase();
                const rows = document.querySelectorAll('#public-books-body tr');
                rows.forEach(row => {
                    const text = row.innerText.toLowerCase();
                    row.style.display = text.includes(term) ? '' : 'none';
                });
            });
        }
        fetchBooks(false);
    }

});

// Shared Function: Fetch and Render
function fetchBooks(isAdmin) {
    const tableBody = isAdmin ? document.getElementById('books-body') : document.getElementById('public-books-body');
    if (!tableBody) return;

    fetch(API_URL)
        .then(res => res.json())
        .then(books => {
            tableBody.innerHTML = '';
            if (books.length === 0) {
                tableBody.innerHTML = '<tr><td colspan="5" style="text-align:center; padding: 2rem;">Library is empty.</td></tr>';
                return;
            }

            books.forEach(book => {
                const row = document.createElement('tr');
                const statusBadge = book.borrowed 
                    ? `<span class="status-badge status-borrowed">Borrowed</span>` 
                    : `<span class="status-badge status-avail">Available</span>`;
                
                let actionBtn = '';
                if (isAdmin) {
                    // Admin Actions: Return (if borrowed), maybe Delete later
                   if (book.borrowed) {
                        actionBtn = `<button onclick="returnBook(${book.id})" class="btn-primary" style="background:var(--warning-color)">Force Return</button>`;
                   } else {
                       actionBtn = `<span style="color:var(--text-secondary)">-</span>`;
                   }
                } else {
                    // Public Actions: Borrow only
                    if (!book.borrowed) {
                         actionBtn = `<button onclick="borrowBook(${book.id})" class="btn-primary">Borrow</button>`;
                    } else {
                        actionBtn = `<button class="btn-primary" disabled style="opacity:0.5; cursor:not-allowed">Borrowed</button>`;
                    }
                }

                row.innerHTML = `
                    ${isAdmin ? `<td style="color:var(--text-secondary)">#${book.id}</td>` : ''} 
                    <td style="font-weight:600;">${book.name}</td>
                    <td>${book.author}</td>
                    <td>${statusBadge}</td>
                    <td>${actionBtn}</td>
                `;
                tableBody.appendChild(row);
            });
        })
        .catch(err => console.error(err));
}

// Global Actions
window.borrowBook = (id) => {
    fetch(`${API_URL}/${id}/borrow`, { method: 'POST' })
        .then(res => {
            if (res.ok) {
                // Refresh whichever table is visible
                const isAdmin = document.body.id === 'admin-page';
                fetchBooks(isAdmin);
            }
        });
};

window.returnBook = (id) => {
    fetch(`${API_URL}/${id}/return`, { method: 'POST' })
        .then(res => {
            if (res.ok) {
                const isAdmin = document.body.id === 'admin-page';
                fetchBooks(isAdmin);
            }
        });
};
