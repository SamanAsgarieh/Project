// OLList.cpp
// ENSF 607  Lab 6 Exercise 1 and 2

#include <iostream>
#include <stdlib.h>
using namespace std;
#include "OLList.h"

OLList::OLList()
: headM(0)
{
}

OLList::OLList(const OLList& source)
{
	copy(source);
}

OLList& OLList::operator =(const OLList& rhs)
{
	if (this != &rhs) {
		destroy();
		copy(rhs);
	}
	return *this;
}

OLList::~OLList()
{
	destroy();
}

void OLList::print() const
{
	cout << '[';
	if (headM != 0) {
		cout << ' ' << headM->item;
		for (const Node *p = headM->next; p != 0; p = p->next)
			cout << ", " << p->item;
	}
	cout << " ]\n";
}

void OLList::insert(const ListItem& itemA)
{
	Node *new_node = new Node;
	new_node->item = itemA;

	if (headM == 0 || itemA <= headM->item ) {
		new_node->next = headM; //new_node is pointing to next which is equal to headM
		headM = new_node;
		// point one
	}
	else {
		Node *before = headM;
		Node *after = headM->next;
		while(after != 0 && itemA > after->item) {
			before = after;
			after = after->next;
		}
		new_node->next = after;
		before->next = new_node;
		// point two
	}
}

void OLList::remove(const ListItem& itemA)
{
	// if list is empty, do nothing
	if (headM == 0 || itemA < headM->item)
		return;

	Node *doomed_node = 0;

	if (itemA == headM->item) {
		doomed_node = headM;
		headM = headM->next;
	}
	else {
		Node *before = headM;
		Node *maybe_doomed = headM->next;
		while(maybe_doomed != 0 && itemA > maybe_doomed->item) {
			before = maybe_doomed;
			maybe_doomed = maybe_doomed->next;
		}
		if (maybe_doomed != 0 && maybe_doomed->item == itemA) {
			doomed_node = maybe_doomed;
			before->next = maybe_doomed->next;
		}
	}
	delete doomed_node;
}
// point three
// the remaining part of this function is missing. As part of exercise B
// students are supposed to complete the rest of the definition of this function.



void OLList::destroy()
{


	Node *cursor = headM;
	while (cursor!= NULL){
		headM = headM->next;
		delete cursor;
		cursor = headM;
	}
	headM = NULL;
}

/* deref head_ref to affect the real head back
	    in the caller. */
//	delete []headM;


void OLList::copy(const OLList& source)
{
	if (source.headM== NULL){
		headM = NULL;
		return;
	}
	else{
		headM = new Node;
		headM->item=source.headM->item;
		Node *after = headM;
		Node * before = source.headM->next;
		while (before != NULL){
			after->next = new Node;
			after = after->next;
			after->item = before->item;
			before = before->next;
		}
		after->next = NULL;
	}

}


