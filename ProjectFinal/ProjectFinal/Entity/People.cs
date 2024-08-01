using System;

namespace ProjectFinal.Entity
{
    public class People
    {
        public string Name { get; set; }
        public bool Gender { get; set; } // true cho nam, false cho nữ
        public int Age { get; set; }

        public void DisplayInfo()
        {
            Console.WriteLine($"Name: {Name}");
            Console.WriteLine($"Gender: {(Gender ? "Male" : "Female")}");
            Console.WriteLine($"Age: {Age}");
        }
    }
}