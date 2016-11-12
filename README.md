# Java Algorithms

Content of the package at the date of writing

## Randomized Queue

A randomized queue is a data structure that allows to push with an O(1) complexity and to pop items randomly chosen, again with an O(1) complexity.

This is of great interest when the order of the items you are working with does not matter.

The dynamic memory allocation choosen ensures that in the average case, the memory consumption is always managed in a secure way without doing much unneeded allocation (basically, it allocates always the same memory amount that was previously occupied when the size of the buffer is exceeded by 1).

## Deque (doubly linked list)

This data structure is well known and used to have an O(1) complexity cost at insertion, being at the start or at the end of the list. However, to retrieve the (n-th) element, the complexity is basically in O(n), as for a standard array-stack, the retrieval cost is always O(1) if you know the index of your element.
