#include <string.h>

char *BoyerMoore( unsigned char *data, unsigned int dataLength, unsigned char *string, unsigned int strLength )
{
    unsigned int skipTable[256], i;
    unsigned char *search;
    register unsigned char lastChar;

    if (strLength == 0)
        return NULL;

    // Initialize skip lookup table
    for (i = 0; i < 256; i++)
        skipTable[i] = strLength;

    search = string;

    // Decrease strLength here to make it an index
    i = --strLength;

    do
    {
        skipTable[*search++] = i;
    } while (i--);

    lastChar = *--search;

    // Start searching, position pointer at possible end of string.
    search = data + strLength;
    dataLength -= strLength+(strLength-1);

    while ((int)dataLength > 0 )
    {
        unsigned int skip;

        skip = skipTable[*search];
        search += skip;
        dataLength -= skip;
        skip = skipTable[*search];
        search += skip;
        dataLength -= skip;
        skip = skipTable[*search];

        if (*search != lastChar) /*if (skip > 0)*/
        {
            // Character does not match, realign string and try again
            search += skip;
            dataLength -= skip;
            continue;
        }

        // We had a match, we could be at the end of the string
        i = strLength;

        do
        {
            // Have we found the entire string?
            if (i-- == 0)
                return search;
        } while (*--search == string[i]);

        // Skip past the part of the string that we scanned already
        search += (strLength - i + 1);
        dataLength--;
    }

    // We reached the end of the data, and didn't find the string
    return NULL;
}
