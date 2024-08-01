using System;
using ProjectFinal.Entity;

namespace ProjectFinal.Repository
{
    public static class PeopleRepository
    {
        public static void DisplayPeopleInfo(People person)
        {
            Console.WriteLine("Info:");
            person.DisplayInfo();

            person.Age++;
            
            Console.WriteLine("\nInformation after incrementing Age:");
            person.DisplayInfo();
        }
    }
}