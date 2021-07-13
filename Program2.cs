using System;

namespace bai2
{
    class Program
    {
        static void Main(string[] args)
        {
            int x;
            Console.WriteLine("Enter a name:");
            string a = Console.ReadLine();
            Console.WriteLine("Enter a number:");
            int b = Convert.ToInt16(Console.ReadLine());
            Console.WriteLine("Enter a number:");
            int c = Convert.ToInt32(Console.ReadLine()); 
            Console.WriteLine("Enter a number:");
            double d = Convert.ToDouble(Console.ReadLine());


            x = c + b;
            Console.WriteLine("the result is :" + x);
            Console.WriteLine("the result is :" + a);
            Console.WriteLine(Convert.ToInt32(d));
            
        }
    }
}
