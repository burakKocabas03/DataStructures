using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Simple_Sorting
{
    internal class BubbleSort
    {
        private long[] arr;
        private int dataCount;

        public BubbleSort(int max) //Constructor
        {
            arr = new long[max];
            dataCount = 0;
        }
        public void insert(int value)
        {
            arr[dataCount] = value;
            dataCount++;
        }
        public void bubbleSort() //sorting array
        {
            for (int j = 0; j < dataCount; j++) 
            {
                for (int i = 0; i < dataCount - 1; i++)
                {
                    if (arr[i] > arr[i + 1])
                    {
                        swap(i, i + 1);
                        display();
                    }
                }
            }   
        }
        public void swap(int x, int y) // swapping the values
        {
            long temp;                 
            temp = arr[y];
            arr[y] = arr[x];
            arr[x] = temp;
        }
        public void display()
        {
            for(int i = 0;i < dataCount;i++) 
            {
                Console.Write(arr[i] + ", ");
                
            }
            Console.WriteLine("\n-----------------------------------------------------------------------");
        }
       
    }   
}
