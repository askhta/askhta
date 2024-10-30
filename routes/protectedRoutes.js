const express = require('express');
const router = express.Router();
const { authorize } = require('../middlewares/authMiddleware');

router.get('/admin-only', authorize(['manage_users']), (req, res) => {
    res.send("Trang quản lý người dùng (chỉ dành cho admin).");
});

router.get('/edit-content', authorize(['create', 'update']), (req, res) => {
    res.send("Trang chỉnh sửa nội dung (dành cho editor và admin).");
});

module.exports = router;
