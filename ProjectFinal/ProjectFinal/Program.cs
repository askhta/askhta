// File: ProjectFinal/Program.cs
using System;
using ProjectFinal.Entity;
using ProjectFinal.Repository;

namespace ProjectFinal
{
    class Program
    {
        static void Main(string[] args)
        {
            int choice;
            do
            {
                Console.WriteLine("Choose an option (0-2):");
                Console.WriteLine("1. People");
                Console.WriteLine("2. Find word in string");
                Console.WriteLine("0. Exit");
                Console.Write("Input your choice: ");
                choice = int.Parse(Console.ReadLine());

                switch (choice)
                {
                    case 1:
                        RunPeopleProgram();
                        break;
                    case 2:
                        RunWordSearchProgram();
                        break;
                    case 0:
                        Console.WriteLine("Exit.");
                        break;
                    default:
                        Console.WriteLine("Invalid choice. Please choose 0-2.");
                        break;
                }

            } while (choice != 0);
        }

        static void RunPeopleProgram()
        {
            People person = new People
            {
                Name = "Marry",
                Gender = true,
                Age = 30
            };

            PeopleRepository.DisplayPeopleInfo(person);
        }

        static void RunWordSearchProgram()
        {
            Console.Write("Input String: ");
            string inputString = Console.ReadLine();

            Console.Write("Input the word to find: ");
            string searchWord = Console.ReadLine();

            int count = WordSearchRepository.CountOccurrences(inputString, searchWord);

            Console.WriteLine($"Word '{searchWord}' appears {count} time(s) in the string.");
        }
    }
}