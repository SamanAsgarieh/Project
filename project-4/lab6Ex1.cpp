// lab6Ex1.cpp
// 
// ENSF 607 Lab 6 Exercise 1 and 2
//

#include <iostream>
using namespace std;

#include "OLList.h"

int main()
{
	OLList the_list;

	cout << "List just after creation: ";
	the_list.print();
	the_list.insert(330);
	the_list.insert(440);
	the_list.insert(220);
	the_list.insert(110);
	cout << "List after some insertions: ";
	the_list.print();
	the_list.remove(550);
	the_list.remove(330);
	cout << "List after some removals: ";
	the_list.print();
	//
	OLList b;
	b = the_list;
	cout << "b's list equals the_list(with many items): ";
	b.print();
	b.remove(220);

	OLList c = b;
	cout<<"c's list:(with only two item): ";
	c.print();

	c.remove(110);
	cout<<"b's list:(after removing 220 from b and 110 from c. It should be like [110,440]): ";
	b.print();
	OLList d = c;
	cout<<"d's list:(with only one item): ";
	d.print();
	OLList e;
	cout<<"e's list:(with no items): ";
	e.print();
	cout << "b after modifying the rest of Nodes.it should remain [110,440]: ";
	b.print();

	cout << "the_list is the same as before";
	the_list.print();

	return 0;
}
