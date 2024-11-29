import mysql.connector
from datetime import date

def connect_database():
    try:
        connection = mysql.connector.connect(
            host = "127.0.0.1",
            user = "root",
            password = "",
            database = "medical_service",
            port = "3306"
        )
        if connection.is_connected():
            print("Welcome to my medical service")
            return connection
    except mysql.connector.Error as err:
        print(f"Error: {err}")
        return None
    
def add_patient(cursor):
    print("New patient")
    name = input(f"Enter name of patient: ")
    dob = input(f"Enter birthyear: ")
    gender = input(f"Enter gender(F/M): ")
    address = input(f"Enter address: ")
    phone = input(f"Enter phone number: ")
    email = input(f"Enter email: ")
    

    cursor.execute("""
        INSERT INTO patients (full_name, date_of_birth, gender, address, phone_number, email) 
        VALUES (%s, %s, %s, %s, %s, %s)
    """, (name, dob, gender, address, phone, email))

def add_doctor(cursor):
    print("New doctor")
    name = input(f"Enter name of doctor: ")
    specialization = input(f"Enter specialization: ")
    phone = input(f"Enter phone number: ")
    email = input(f"Enter email: ")
    years_of_experience = input(f"Enter years of experience: ")
    
    cursor.execute("""
            INSERT INTO doctors (full_name, specialization, phone_number, email, years_of_experience) 
            VALUES (%s, %s, %s, %s, %s)
        """, (name, specialization, phone, email, years_of_experience))

def main():
    db = connect_database()
    if db is None:
        return
    cursor = db.cursor()

    num_patients = int(input("Enter the number of patients to add: "))
    for _ in range(num_patients):
        print(f"\nAdding patient {_ + 1}/{num_patients}:")
        add_patient(cursor)

    num_doctors = int(input("Enter the number of doctors to add: "))
    for _ in range(num_doctors):
        print(f"\nAdding doctor {_ + 1}/{num_doctors}:")
        add_doctor(cursor)

    db.commit()
    print("All changes saved to the database.")

    cursor.close()
    db.close()

if __name__ == "__main__":
    main()