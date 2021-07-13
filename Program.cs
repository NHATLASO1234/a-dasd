using System;

namespace bai4
{
    class Program
    {
        static void Main(string[] args)
        {
            Console.WriteLine("Enter a number: ");
            int a = Convert.ToInt32(Console.ReadLine());
            Console.WriteLine("Enter a number: ");
            int b = Convert.ToInt32(Console.ReadLine());
            if (a > b)
            {
                Console.WriteLine("It's a bad one ");
            }
            else
            {
                Console.WriteLine("It's a good one");
            }
        }
    }
}
