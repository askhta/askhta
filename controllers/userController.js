const User = require('../models/User');
const Role = require('../models/Role');
const bcrypt = require('bcrypt');
const jwt = require('jsonwebtoken');
const registerUser = async (req, res) => {
    const { name, email, password, roles } = req.body; 
    try {
        const existingUser = await User.findOne({ email });
        if (existingUser) {
            return res.status(400).json({ message: 'Người dùng đã tồn tại' });
        }
        const user = new User({
            name,
            email,
            password, 
            roles: roles || ['user'] 
        });

        await user.save();
        res.status(201).json({ message: 'Đăng ký thành công' });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Có lỗi xảy ra khi đăng ký' });
    }
};


const loginUser = async (req, res) => {
    const { email, password } = req.body;

    try {

        const user = await User.findOne({ email });
        if (!user) {
            return res.status(401).json({ message: 'Email hoặc mật khẩu không đúng' });
        }


        const isMatch = await user.isValidPassword(password); 
        if (!isMatch) {
            return res.status(401).json({ message: 'Email hoặc mật khẩu không đúng' });
        }

        // Tạo JWT
        const token = jwt.sign({ id: user._id, roles: user.roles }, process.env.JWT_SECRET, { expiresIn: '1h' });
        res.cookie('token', token, { httpOnly: true }); 
        res.status(200).json({ message: 'Đăng nhập thành công', token });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Có lỗi xảy ra khi đăng nhập' });
    }
};


const getProtectedData = async (req, res) => {
    try {
        const user = req.user;
        res.status(200).json({ message: 'Dữ liệu bảo vệ', user });
    } catch (error) {
        console.error(error);
        res.status(500).json({ message: 'Có lỗi xảy ra khi truy cập dữ liệu bảo vệ' });
    }
};


module.exports = {
    registerUser,
    loginUser,
    getProtectedData
};
