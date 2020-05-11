/*
 * hydro.h
 *
 *  Created on: Mar. 25, 2020
 *      Author: saman
 */

#ifndef HYDRO_H_
#define HYDRO_H_
#include "list.h"

class hydro {
public:
	hydro();
	void displayHeader();
	int readData(FlowList & source) ;
	int menu();
	void display(FlowList & source);
	void addData (FlowList & source);
	void removeData(FlowList& source);
	double average(FlowList& source);
	double median(FlowList &source);
	void saveDara(FlowList &source);
	void pressEnter();
	int numRecord;
private:
	virtual ~hydro();
};

#endif /* HYDRO_H_ */
