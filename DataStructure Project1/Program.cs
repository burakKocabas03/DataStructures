using OfficeOpenXml;
using System;
using System.Collections.Generic;
using System.IO;
using LicenseContext = OfficeOpenXml.LicenseContext;

namespace Project1._2
{
    internal class Program
    {
        static void Main(string[] args)
        {

            object[][] jaggedArray2 = ExcelReadJagged();
            int[][] jaggedArrayInt = ConvertToIntJagged(jaggedArray2);
            string[] cityList2 = ExcelReadCity(ExcelReadJagged());



            // Metodlarımız burda çağırdık özel olarak çalıştırmak istediğiniz metodu diğer 4 metodu yoruma alarak özel olarak onun sonucuna bakabilirsiniz
            DistanceToGivenCity(41, 200, jaggedArray2, cityList2, jaggedArrayInt);//Bu
            RandomCityDistance(jaggedArray2,cityList2 );
            NearestAndFarthestCity(jaggedArray2,cityList2);            
            List<int> returnList = FindMaxCities(jaggedArrayInt, 41, 200, new List<int>());
            foreach (int i in returnList)
            {
                Console.Write(cityList2[i + 1] + " ");
            }
            Console.WriteLine();
            int totalDistance = 0;
            for (int i =0;i < returnList.Count-1; i++)
            {
                if (returnList[i] > returnList[i + 1])
                {
                    totalDistance += jaggedArrayInt[returnList[i]][returnList[i + 1]];
                }
                else
                {
                    totalDistance += jaggedArrayInt[returnList[i + 1]][returnList[i]];
                }
            }
            Console.WriteLine("Gidilen Toplam Mesafe:  " + totalDistance);
            Console.Read();
            
        }
        static object[][] ExcelReadJagged()
        {
            object[][] jaggedArray = new object[81][];
            ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
            string filePath = "/Users/burakkocabas/Downloads/ilmesafe.xlsx";

            using (var package = new ExcelPackage(new FileInfo(filePath)))
            {
                var worksheet = package.Workbook.Worksheets[0]; // İlk sayfa
                int rowCount = worksheet.Dimension.Rows;
                int columnCount = worksheet.Dimension.Columns;

                object[,] excelData = new object[rowCount, columnCount];
                // Excellden okunan verileri 2 boyutlu listede tutmak için
                for (int row = 1; row <= rowCount; row++)
                {
                    for (int col = 1; col <= columnCount; col++)
                    {
                        excelData[row - 1, col - 1] = worksheet.Cells[row, col].Text;
                    }
                }
                // 2 boyutlu listedeki verileri jagged array'e ekler
                for (int row = 0; row < 81; row++)
                {
                    jaggedArray[row] = new object[row];
                    for (int col = 0; col < row; col++)
                    {
                        jaggedArray[row][col] = excelData[row + 2, col + 2];
                    }
                }
                return jaggedArray;
            }
        }
        static int[][] ConvertToIntJagged(object[][] jaggedArray)
        {

            int[][] jaggedArrayInt = new int[81][];
            for (int row = 0; row < 81; row++)
            {
                jaggedArrayInt[row] = new int[row];
                for (int col = 0; col < row; col++)
                {

                    string stringValues = (string)jaggedArray[row][col];
                    int intValue = Int32.Parse(stringValues);
                    jaggedArrayInt[row][col] = intValue;
                }
            }
            return (jaggedArrayInt);
        }
        static string[] ExcelReadCity(object[][] array)
        {
            string[] cityList = new string[82];
            ExcelPackage.LicenseContext = LicenseContext.NonCommercial;
            string filePath = "/Users/burakkocabas/Downloads/ilmesafe.xlsx";
            using (var package = new ExcelPackage(new FileInfo(filePath)))
            {
                var worksheet = package.Workbook.Worksheets[0]; // İlk sayfa
                int rowCount = worksheet.Dimension.Rows;
                int columnCount = worksheet.Dimension.Columns;

                object[,] excelData = new object[rowCount, columnCount];
                // Excellden okunan verileri 2 boyutlu listede tutmak için
                for (int row = 1; row <= rowCount; row++)
                {
                    for (int col = 1; col <= columnCount; col++)
                    {
                        excelData[row - 1, col - 1] = worksheet.Cells[row, col].Text;
                    }
                }
                // Sadece il isimlerinin tutulduğu bir liste oluşturur
                for (int column = 0; column < 1; column++)
                {
                    for (int row = 0; row < 81; row++)
                    {
                        cityList[row + 1] = Convert.ToString(excelData[row + 2, column + 1]);
                    }
                }
                return cityList;
            }
        }
        static void NearestAndFarthestCity(object[][] array, string[] cityArray)
        {
            string citymin1 = "";
            string citymin2 = "";
            string citymax1 = "";
            string citymax2 = "";
            int minDistance = 99999999;
            int maxDistance = 0;
            // Jagged Arrayı tarayarak en küçük ve en büyük mesafeyi bulma yeri
            for (int i = 0; i < 81; i++)
            {
                for (int j = 0; j < i; j++)
                {
                    if (array[i][j] is string)
                    {
                        string stringValues = (string)array[i][j];
                        int.TryParse(stringValues, out int searchDistance);
                        if (minDistance > searchDistance)
                        {
                            minDistance = searchDistance;
                            citymin1 = cityArray[i + 1];
                            citymin2 = cityArray[j + 1];
                        }
                        if (maxDistance < searchDistance)
                        {
                            maxDistance = searchDistance;
                            citymax1 = cityArray[i + 1];
                            citymax2 = cityArray[j + 1];
                        }

                    }
                }

            }
            Console.WriteLine("Nearest 2 City : " + citymin1 + "," + citymin2
                + " The Distance Between Them : " + minDistance + "\nFarthest 2 City: "
                + citymax1 + "," + citymax2 + " The Distance Between Them : " + maxDistance);
            Console.ReadKey();
        }
        static void DistanceToGivenCity(object info, int distance, object[][] array, string[] cityList, int[][] jaggedArrayInt)
        {
            int searchDistance = 0;
            int searchIndex = 0;
            // if elif else Blokları gelen veriye göre indis alma işlemi yapar
            if (info is int || (int)info < 82 || (int)info > 0)
            {

                int intInfo = (int)info;
                searchIndex = intInfo - 1;

            }
            else if (info is string)
            {

                string stringInfo = ((string)info);
                stringInfo = stringInfo.ToUpper();
                searchIndex = Array.IndexOf(cityList, stringInfo) - 1;


            }
            else
            {
                Console.WriteLine("Unacceptable data tpye for City information");
            }
            //Verilen ilden gidilecek illeri ve uzaklıkları bulan kod bloğu
            try
            {
                Console.WriteLine("Selected City = " + cityList[searchIndex + 1]);
                for (int i = 0; i <= 80; i++)
                {
                    if (i == searchIndex)
                    {
                        continue;
                    }


                    else if (i < searchIndex)
                    {
                        searchDistance = jaggedArrayInt[searchIndex][i];
                    }
                    else
                    {
                        searchDistance = jaggedArrayInt[i][searchIndex];
                    }

                    if (distance > 0 && distance >= searchDistance)
                    {
                        Console.WriteLine("City " + cityList[i + 1] + " Distance : " + searchDistance);
                    }
                }
            }
            catch (IndexOutOfRangeException)
            {
                Console.WriteLine("ERROR! Enter the name of the city or number between 1-81");
            }
            Console.ReadKey();

        }

        // En uzak ve En yakın ikili illeri bulan ve mesafelerini yazdıran metod
        static void RandomCityDistance(object[][] array, string[] cityArray)
        {
            string[,] distanceList = new string[5, 5];
            int[] randomNumberList = new int[5];
            Random random = new Random();
            for (int i = 0; i < 5; i++)
            {

                int randomNumber = random.Next(1, 82);
                randomNumberList[i] = randomNumber;
            }
            for (int i = 0; i < 5; i++)
            {
                for (int j = 0; j < 5; j++)
                {
                    if (i == j)
                    {
                        distanceList[i, j] = "0";
                    }
                    else
                    {
                        if (randomNumberList[i] > randomNumberList[j])
                        {
                            distanceList[i, j] = (string)array[randomNumberList[i] - 1][randomNumberList[j] - 1];
                        }
                        else if (randomNumberList[i] == randomNumberList[j])
                        {
                            distanceList[i, j] = "0";
                        }


                        else
                        {
                            distanceList[i, j] = (string)array[randomNumberList[j] - 1][randomNumberList[i] - 1];

                        }
                    }
                }
            }
            Console.Write("                   ");
            for (int i = 0; i < 5; i++)
            {
                Console.Write($"{cityArray[randomNumberList[i]],-20}");
            }
            Console.WriteLine();


            for (int i = 0; i < 5; i++)
            {
                Console.Write($"{cityArray[randomNumberList[i]],-20}");

                for (int count = 0; count < 5; count++)
                {
                    Console.Write($"{distanceList[i, count],-20}");
                }
                Console.WriteLine();
            }
            Console.Read();
        }
        static List<int> FindMaxCities(int[][] distanceArr, int currCityIndex, int distanceLeft, List<int> citiesVisited)
        {
            currCityIndex -= 1;
            citiesVisited.Add(currCityIndex);

            int max = -1;
            List<int> temp;
            List<int> tempCitiesVisited = new List<int>();


            int distanceToCity = 0;
            // Bulunduğum şehirden her ili olan uzaklıklara bakmak içiniçin 81 döngülü bir for döngüsü var
            for (int i = 0; i < 81; i++)
            {   // İlk 3 if de iki şehir arasındaki mesafeyi buluyor ve distanceToCity adı aldında değişkene atıyor
                if (i == currCityIndex)
                {
                    continue;
                }

                if (i < currCityIndex)
                {
                    distanceToCity = distanceArr[currCityIndex][i];
                }
                if (i > currCityIndex)
                {
                    distanceToCity = distanceArr[i][currCityIndex];
                }
                // şehir lisetesine gidilecek şehirin olup olamdığına ve elimdeki mesafe ile diğer şehire gidip gidemeyeceğimize bakan if bloğu
                if (!citiesVisited.Contains(i) && distanceToCity < distanceLeft)

                {   // Recursive şeklinde kendini tekrarlayarak her ilin her seçeneğine bakmasını sağlar
                    temp = FindMaxCities(distanceArr, i+1, distanceLeft - distanceToCity, new List<int>(citiesVisited));
                   
                    if (temp.Count > max)
                    {
                        //tempCitiesVisited listesi recursive çağırımlarda orjinal listeye zarar gelmemesi için tanımlandı

                        max = temp.Count;
                        tempCitiesVisited = new List<int>(temp);

                    }
                }
            }
            if (tempCitiesVisited.Count != 0)
            {
                citiesVisited = new List<int>(tempCitiesVisited);
            }

            return citiesVisited;

        }

    }
}


