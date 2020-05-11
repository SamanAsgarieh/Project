/*
 * list.cpp
 *
 *  Created on: Mar. 23, 2020
 *      Author: saman
 */
// FlowList.cpp
// ENSF 607  Lab 6 Exercise 1 and 2

#include <iostream>
#include <stdlib.h>
using namespace std;
#include "list.h"
std::string underline(const std::string &s) {
	return std::string(s.length()+1, '_');
}
FlowList::FlowList()
: headM(0)
{
	cursorM=0;
}

FlowList::FlowList(const FlowList& source)
{
	copy(source);
}


FlowList& FlowList::operator =(const FlowList& rhs)
{
	if (this != &rhs) {
		destroy();
		copy(rhs);
	}
	return *this;
}

FlowList::~FlowList()
{
	destroy();
}

void FlowList::reset()
{
	if(headM!=NULL){
		cursorM = headM;
	}
}
bool FlowList::isOn() const
{
	if(cursorM!=NULL){
		return true;
	}
	else
		return false;
}
const Node *FlowList::cursor()const{
	return cursorM;
}

void FlowList::forward()
{
	if(cursorM!=NULL || cursorM->next==NULL){
		cursorM = cursorM->next;
	}
}
const ListItem&FlowList:: getItem() const{

	if(cursorM!=NULL){
		return cursorM->item;
	}
}

//
void FlowList::insert(const ListItem& itemA)
{
//	cout<<"insert1"<<endl;
	Node *new_node = new Node;
	new_node->item = itemA;

	if (headM == NULL ||  itemA.flow <= headM->item.flow) {

		new_node->next = headM;
		headM = new_node;
		// point one
	}
	else {
//		cout<<"insert2"<<endl;
		Node *before = headM;
		Node *after = headM->next;
		while(after != NULL && itemA.flow > after->item.flow) {
			before = after;
			after = after->next;
		}
		new_node->next = after;
		before->next = new_node;
		// point two
	}
}



void FlowList::remove(int target_year)
{
	if (headM == 0)
		return;

	Node *doomed_node = 0;
	if (target_year == headM->item.year) {
		doomed_node = headM;
		headM = headM->next;
		cursorM=NULL;
		delete doomed_node;

	}
	else{
		Node *before = headM;
		Node *maybe_doomed = headM->next;
		while(maybe_doomed != NULL){
			if(maybe_doomed->item.year == target_year){
				doomed_node =maybe_doomed;
				before->next = maybe_doomed->next;
				cursorM=NULL;
				delete doomed_node;
				break;
			}
			before = before->next;
			maybe_doomed=maybe_doomed->next;
		}
	}

}

//// point three
//// the remaining part of this function is missing. As part of exercise B
//// students are supposed to complete the rest of the definition of this function.
//
//
//
void FlowList::destroy()
{

	Node *doomed_node = 0;
	if (headM == 0)
		return;
	else{
		Node *before = headM;
		Node *maybe_doomed = headM->next;
		while(maybe_doomed != 0) {
			before = maybe_doomed;
			maybe_doomed = maybe_doomed->next;
			doomed_node = maybe_doomed;
			before->next = maybe_doomed;
			delete doomed_node;
		}
	}
}



void FlowList::print(int count) const
{
	Node *p = headM->next;
	constexpr auto TEXT = "Year\tFlow (in billions of cubic meters)";
	std::cout << TEXT << std::endl << underline(TEXT) << std::endl;
		cout << headM->item.year<<"\t"<<headM->item.flow<<endl;
		int c = 1;
		while(c<count){
			cout << p->item.year<<"\t"<<p->item.flow<<endl;
			p=p->next;
			c++;
//			cout<<c<<endl;
	}
}


int FlowList::count()const{
	int size=0;
	const Node *p = headM;
	while ( p != NULL){
		p = p->next;
		size=size+1;
	}
	return size;
}


void FlowList::copy(const FlowList& source){

	if (source.headM== NULL){
		headM = NULL;
		return;
	}
	else{
		headM = new Node;
		headM->item = source.headM->item;
		Node *after = headM;
		Node *before = source.headM->next;
		while (before != NULL){
			after->next = new Node;
			after = after->next;
			after->item = before->item;
			before = before->next;
		}
		//		after->next = NULL;//to disconnect the node from headM
	}

}
