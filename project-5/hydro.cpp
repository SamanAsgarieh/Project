/*
 * hydro.cpp
 *
 *  Created on: Mar. 25, 2020
 *      Author: saman
 */

#include "hydro.h"
#include "list.h"
#include <fstream>
#include <iostream>
#include <stdlib.h>
#include <string>
using namespace std;


void pressEnter(){

	cout<<"<<< Press Enter to Continue>>>>"<<endl;
	getchar();
	cin.ignore();
}

void displayHeader(){
	cout<<"HEF Hydropower Studies – Winter 2019"<<endl;
	cout<<"Program: Flow Studies"<<endl;
	cout<<"Version: 1.0"<<endl;
	cout<<"Lab section: 6"<<endl;
	cout<<"Instructor : Moshirpour"<<endl;
	cout<<"Teaching Assistant(s): Masoud/Fatemeh"<<endl;
	cout<<"Produced by: Saman"<<endl;
	pressEnter();
}

int readData(FlowList & source){
	int numRecord=0;
	string file_name = "flow.txt";
	//	string delimiter = "      ";
	string line;
	ifstream inObj;// (file_name.c_str());
	inObj.open(file_name.c_str());
	if (inObj.is_open())
	{

		while(getline(inObj, line)) {
			//string year = line.substr(0, line.find(delimiter));

			int year= stoi( line.substr(0,4));
			double flow =stod(line.substr(10, 15));
			ListItem p1 = {year, flow};
			source.insert(p1);
			numRecord++;
		}
		inObj.close();
	}
//	cout<<numRecord<<endl;
	return numRecord;
}

double average(FlowList &source){
	source.reset();
	Node const  *p=source.cursor();
	double sum=0;
	while (p!=NULL){
		sum+=p->item.flow;
		p=p->next;
	}
	int totalNode=source.count();
	cout<<"The annual average of the flow is: "<<endl;
	return sum/totalNode;
}


double median(FlowList &source){
	source.reset();
	int totalNode=source.count();
	Node const  *p=source.cursor();
	int count=0;
	bool odd = totalNode%2 != 0 ? true: false;
	if(odd){
		int middle=totalNode/2+1;
		while(p!=NULL){
			count++;
			if(middle==count){
				cout<<average(source)<<" millions cubic meter."<<endl;
							cout<<"\nThe median flow is: "<<endl;
				return p->item.flow;
			}
			p=p->next;
		}
	}
	else{
		int middle=totalNode/2;
		while(p!=NULL){
			count++;
			if(middle==count){
				cout<<average(source)<<" millions cubic meter."<<endl;
							cout<<"\nThe median flow is: "<<endl;
				return p->item.flow;
			}
			p=p->next;
		}
	}
	source.reset();
return 0;
}


void display(FlowList & source,int count){
	source.print(count);
	cout<<median(source)<<" millions cubic meter."<<endl;

}


void saveData(FlowList& source){
	ofstream outObj;
	outObj.open("flow.txt");
	string line;
	source.reset();

	Node const  *p=source.cursor();
	while(p!=NULL){
		line = to_string(p->item.year)+"      "+to_string(p->item.flow);
		outObj <<  line << endl;
		p=p->next;
	}
	outObj.close();
	cout<<"Data are saved into the file."<<endl;
}


void removeData(FlowList &source){
	source.reset();
	int yer;
	cout<<"Pleas enter the year that you want to remove: "<<endl;
	cin>>yer;
	Node const  *p=source.cursor();
	while (p!=NULL){
		if(p->item.year==yer){
			source.remove(yer);
			cout<<"Record was successfully removed."<<endl;
			return;
		}
		p=p->next;
	}
	cout<<"Error: No such a data."<<endl;
	cout<<endl;
}




void addData (FlowList& source){
	source.reset();//if head!=NULL,cursorM=headM
	Node const  *p=source.cursor();//Since cursor is private, we use cursor()
	int year;
	double flow;
	cout<<"Please enter a year: "<<endl;
	cin>>year;
	cout<<"Please enter the flow: "<<endl;
	cin>>flow;
	ListItem item = {year, flow};
	while (p!=NULL){
		if(p->item.year==item.year){
			cout<<"Error: duplicate data."<<endl;
			return;
		}
		p=p->next;
	}
	source.insert(item);//if not duplicate, insert to list
	cout<<"New record inserted successfully."<<endl;

	// check for duplicate

}



int menu(){
	cout<<"Please select on the following operations"<<endl;
	cout<<"		1. Display flow list, average and median"<<endl;
	cout<<"		2. Add data."<<endl;
	cout<<"		3. Save data into the file"<<endl;
	cout<<"		4. Remove data"<<endl;
	cout<<"		5. Quit"<<endl;
	cout<<"		Enter your choice (1, 2, 3, 4, of 5):"<<endl;
	int selected;
	cin>>selected;
	return selected;

}

int main()
{

	FlowList x;
	int numRecords;
	displayHeader();
	numRecords = readData(x);
	int quit =0;
	while(1){
		switch(menu()){
		case 1:
			display(x,x.count());
			pressEnter();

			break;
		case 2:
			addData(x);
			pressEnter();
			break;
		case 3:
			saveData(x);
			pressEnter();
			break;
		case 4:
			removeData(x);
			pressEnter();
			break;
		case 5:
			cout << "\nProgram terminated!\n\n";
			quit = 1;
			break;
		default:
			cout << "\nNot a valid input.\n";
			pressEnter();
		}
		if(quit == 1){
			cout << "\n---------------------\n";
		break;}
	}

	// Creating a copy of FlowList x called copy1
	FlowList copy1;
	copy1 = x;
//	// In the following section call addData to add
//	// following records (year, flow) to copy1:
//	// 2012 459.99
	addData(copy1);
//	// 2013 2000.34
	addData(copy1);
//	// Use the following code to create a copy of copy1 called copy2
	FlowList copy2 = copy1;
//	// removing three records from copy2
	copy2.remove(1922);
	copy2.remove(2003);
	copy2.remove(2001);
	// Display the values in three list copy 2, copy1, and x
	cout << "\n values in copy2 are: "<<endl;
	display(copy2,copy2.count());
//	cout << "\n values in copy1 are: "<<endl;
//	display(copy1);
//	cout << "\n values in x are: "<<endl;
//	display(x,x.count());
	return 0;
}
