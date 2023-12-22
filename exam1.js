// Import React and CSS
import React from 'react';
import './App.css';

// Create a functional component Student that takes props: id, name, image and email
function Student(props) {
  // Use state to store the visibility of the extra details
  const [showDetails, setShowDetails] = React.useState(false);

  // Create a function to toggle the visibility of the extra details
  function toggleDetails() {
    setShowDetails(!showDetails);
  }

  // Return the JSX code for the Student component
  return (
    <div className="student-card">
      <img src={props.image} alt={props.name} />
      <h3>{props.name}</h3>
      <p>ID: {props.id}</p>
      <button onClick={toggleDetails}>
        {showDetails ? 'Hide' : 'Show'} Details
      </button>
      {showDetails && <p>Email: {props.email}</p>}
    </div>
  );
}

// Create a main component App that renders a list of students
function App() {
  // Create an array of student objects with properties: id, name, image and email
  const students = [
    {
      id: 1,
      name: 'Nguyễn Văn A',
      image: 'https://randomuser.me/api/portraits/men/1.jpg',
      email: 'nguyenvana@gmail.com',
    },
    {
      id: 2,
      name: 'Trần Thị B',
      image: 'https://randomuser.me/api/portraits/women/2.jpg',
      email: 'tranb@gmail.com',
    },
    {
      id: 3,
      name: 'Lê Văn C',
      image: 'https://randomuser.me/api/portraits/men/3.jpg',
      email: 'levanc@gmail.com',
    },
  ];

  // Return the JSX code for the App component
  return (
    <div className="app">
      <h1>Danh sách sinh viên</h1>
      <div className="student-list">
        {students.map((student) => (
          <Student
            key={student.id}
            id={student.id}
            name={student.name}
            image={student.image}
            email={student.email}
          />
        ))}
      </div>
    </div>
  );
}

// Export the App component
export default App;