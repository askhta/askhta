using System;

namespace ProjectFinal.Repository
{
    public static class WordSearchRepository
    {
        public static int CountOccurrences(string str, string word)
        {
            int count = 0;
            int index = 0;

            while ((index = str.IndexOf(word, index, StringComparison.OrdinalIgnoreCase)) != -1)
            {
                count++;
                index += word.Length;
            }

            return count;
        }
    }
}   