/*************************
 *Michael Ellis*
 *CPSC 2310 Fall 24*
 *mje2*
 *Dr. Yvon Feaster*
*************************/

#include "functions.h"

node_t* createList(FILE* input, node_t** head) {
    node_t* new_node = NULL;

    // !feof(input) - this continues to loop until the end of the file is reached
    while (!feof(input)) {
        new_node = readNodeInfo(input);
        if (new_node != NULL) {
            add(&new_node, head);
        }
    }

    return *head;
}

node_t* readNodeInfo(FILE* input) {
    node_t* new_node = (node_t*)malloc(sizeof(node_t));
    if (new_node == NULL) {
        fprintf(stderr, "Memory allocation failed.\n");
        exit(1);
    }

    // Since scanset reads information as a char, i need to first store month, day, and year 
    // as chars and convert them from chars to ints.
    char month_str[10], day_str[3], year_str[5];

    fscanf(input, "%49[^,],%49[^,],%9[^,],%14[^,]%9[^,],%2[^,],%4[^\n]\n",
                             new_node->first_name,
                             new_node->last_name,
                             new_node->major,
                             new_node->communication,
                             month_str, day_str, year_str);

    // convert date strings to integers using atoi()
    new_node->birthday.month = atoi(month_str);
    new_node->birthday.day = atoi(day_str);
    new_node->birthday.year = atoi(year_str);

    new_node->next = NULL;
    return new_node;
}

void add(node_t** node, node_t** head) {
    if (*head == NULL) {
        *head = *node;
    } else { 
        // traverse through the list until we get to the end
        node_t* temp = *head;
        while (temp->next != NULL) {
            temp = temp->next;
        }
        temp->next = *node;
    }
}

void printList(FILE* output, node_t* head) {
    if (head == NULL) {
        fprintf(stderr, "The list is empty.\n");
        exit(1);
    }

    printBorder(output);
    fprintf(output, "LIST INFO:\n");

    node_t* temp = head;
    while (temp != NULL) {
        fprintf(output, "Name: %s %s\n", temp->first_name, temp->last_name);
        fprintf(output, "Date of Birth: %d %d, %d\n", 
                temp->birthday.month, temp->birthday.day, temp->birthday.year);
        fprintf(output, "Degree: %s\n", temp->major);
        fprintf(output, "Preferred method of communication: %s\n", temp->communication);
        temp = temp->next;
    }

    printBorder(output);
}

void printBorder(FILE* output) {
    for (int i = 0; i < 80; i++) {
        fputc('*', output); 
    }
    fputc('\n', output); // dont know if im supposed to do this or not
}

void deleteList(node_t** head) {
    node_t* temp = *head;
    node_t* next_node = NULL;

    while (temp != NULL) {
        next_node = temp->next;
        free(temp);
        temp = next_node;
    }

    *head = NULL;
}