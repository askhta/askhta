const mongoose = require('mongoose');
const User = require('./models/User');
const Role = require('./models/Role');
const Permission = require('./models/Permission');

async function seedDatabase() {
    await mongoose.connect('mongodb://localhost:27017/yourdatabase', { useNewUrlParser: true, useUnifiedTopology: true });

    // Tạo quyền
    const createPermission = new Permission({ name: 'create', description: 'Cho phép tạo mới' });
    const updatePermission = new Permission({ name: 'update', description: 'Cho phép cập nhật' });
    const manageUsersPermission = new Permission({ name: 'manage_users', description: 'Quản lý người dùng' });

    await createPermission.save();
    await updatePermission.save();
    await manageUsersPermission.save();

    // Tạo vai trò
    const adminRole = new Role({ name: 'admin', permissions: [manageUsersPermission._id] });
    const editorRole = new Role({ name: 'editor', permissions: [createPermission._id, updatePermission._id] });
    
    await adminRole.save();
    await editorRole.save();

    // Tạo người dùng
    const adminUser = new User({ username: 'admin', email: 'admin@example.com', password: 'password', roles: [adminRole._id] });
    const editorUser = new User({ username: 'editor', email: 'editor@example.com', password: 'password', roles: [editorRole._id] });
    
    await adminUser.save();
    await editorUser.save();

    console.log("Dữ liệu mẫu đã được tạo thành công.");
    await mongoose.disconnect();
}

seedDatabase().catch(console.error);
