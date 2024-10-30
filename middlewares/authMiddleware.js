const jwt = require('jsonwebtoken');
const User = require('../models/User'); 


const authenticate = async (req, res, next) => {
    const token = req.cookies.token; 

    if (!token) {
        return res.status(403).json({ message: 'Không có quyền truy cập' });
    }

    try {
        const decoded = jwt.verify(token, process.env.JWT_SECRET);
        req.user = await User.findById(decoded.id).populate('roles');
        next();
    } catch (error) {
        console.error(error);
        res.status(401).json({ message: 'Token không hợp lệ' });
    }
};

const authorize = (allowedRoles) => {
    return async (req, res, next) => {
        if (!req.user) {
            return res.status(403).json({ message: 'Không có quyền truy cập' });
        }

        const userRoles = req.user.roles.map(role => role.name);
        const hasPermission = allowedRoles.some(role => userRoles.includes(role));
        
        if (!hasPermission) {
            return res.status(403).json({ message: 'Không có quyền truy cập' });
        }

        next();
    };
};

module.exports = { authenticate, authorize };
