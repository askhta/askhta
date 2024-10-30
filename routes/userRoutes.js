const express = require('express');
const User = require('../models/User');
const jwt = require('jsonwebtoken'); 
const { authenticate, authorize } = require('../middlewares/authMiddleware'); 
const router = express.Router();

router.post('/register', async (req, res) => {
    const { name, email, password, roles } = req.body;

    try {
        const existingUser = await User.findOne({ email });
        if (existingUser) {
            return res.status(400).json({ message: 'Người dùng đã tồn tại' });
        }

        const newUser = new User({ name, email, password, roles });
        await newUser.save();

        res.status(201).json({ message: 'Người dùng đã được đăng ký thành công' });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Có lỗi xảy ra khi đăng ký' });
    }
});

router.post('/login', async (req, res) => {
    const { email, password } = req.body;

    try {
        const user = await User.findOne({ email });
        if (!user) {
            return res.status(404).json({ message: 'Người dùng không tồn tại' });
        }

        const isMatch = await user.isValidPassword(password);
        if (!isMatch) {
            return res.status(401).json({ message: 'Mật khẩu không đúng' });
        }

        // Tạo JWT
        const token = jwt.sign({ id: user._id, roles: user.roles }, process.env.JWT_SECRET, { expiresIn: '1h' });
        
        // Gửi cookie chứa token
        res.cookie('token', token, { httpOnly: true }); 
        res.status(200).json({ message: 'Đăng nhập thành công', token });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Có lỗi xảy ra khi đăng nhập' });
    }
});

router.get('/me', authenticate, async (req, res) => {
    try {
        const user = req.user; 
        
        if (!user) return res.status(404).json({ message: 'Người dùng không tồn tại' });
        res.status(200).json(user); 
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Lỗi máy chủ' });
    }
});


router.post('/logout', (req, res) => {
    res.clearCookie('token'); 
    res.status(200).json({ message: 'Đăng xuất thành công' });
});


router.get('/admin', authenticate, authorize(['admin']), (req, res) => {
    res.status(200).json({ message: 'Bạn có quyền truy cập vào trang quản trị' });
});

module.exports = router;
