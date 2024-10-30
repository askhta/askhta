require('dotenv').config();
const express = require('express');
const mongoose = require('mongoose');
const cookieParser = require('cookie-parser');
const { auth } = require('express-openid-connect');
const userRoutes = require('./routes/userRoutes');
const protectedRoutes = require('./routes/protectedRoutes');

const app = express(); // Khởi tạo ứng dụng Express

// Kết nối đến MongoDB
mongoose.connect(process.env.MONGODB_URI, {
    useNewUrlParser: true,
    useUnifiedTopology: true
}).then(() => {
    console.log("Kết nối thành công với MongoDB");
}).catch(error => {
    console.error("Kết nối thất bại:", error);
});

// Cấu hình Auth0
const config = {
    authRequired: false,
    auth0Logout: true,
    secret: process.env.AUTH0_SECRET || 'a long, randomly-generated string stored in env',
    baseURL: process.env.AUTH0_BASE_URL || 'http://localhost:3000',
    clientID: process.env.AUTH0_CLIENT_ID || 'koYbZSTu4NZ5pQBNMUpnXNmoiq8voxld',
    issuerBaseURL: process.env.AUTH0_DOMAIN || 'https://dev-hak65tnzavnigb16.us.auth0.com',
    routes: {
        callback: '/callback'
    }
};

// Middleware
app.use(express.json()); 
app.use(cookieParser()); 
app.use(auth(config)); 

// Routes
app.use('/api', userRoutes); 
app.use('/api/protected', protectedRoutes);

// Route gốc
app.get('/', (req, res) => {
    res.send('Welcome to the User API!');
});

// Khởi chạy server
const PORT = process.env.PORT || 3000;
app.listen(PORT, () => {
    console.log(`Server đang chạy trên cổng ${PORT}`);
});
