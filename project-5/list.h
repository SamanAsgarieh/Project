/*
 * list.h
 *
 *  Created on: Mar. 23, 2020
 *      Author: saman
 */

#ifndef LIST_H_
#define LIST_H_

//typedef int ListItem;

struct ListItem {
	int year;
	double flow;
};

struct Node {
	ListItem item;
	Node *next;
};

class FlowList {
public:
	// CONSTRUCTOR, DESTRUCTOR, ETC. GOES HERE
	FlowList();
	FlowList& operator =(const FlowList& rhs);
	FlowList(const FlowList& source);
	~FlowList();
	const ListItem& getItem() const;
	// REQUIRES: cursorM != NULL.
	// PROMISES: returns the item to which cursorM is attached to.
	void reset();
	bool isOn() const;
	const Node *cursor()const;
	void forward();
	void insert(const ListItem& itemA);

	void remove(int target_year);

	int count ()const;
	void print(int) const;
private:
	Node *headM;
	Node *cursorM;
	void copy(const FlowList& source);
	void destroy();
};
#endif
