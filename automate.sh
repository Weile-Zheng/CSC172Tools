#!/bin/bash

# Color variables
red='\033[0;31m'
green='\033[0;32m'
blue='\033[0;34m'
magenta='\033[0;35m'
# Clear the color after that
clear='\033[0m'



start=$SECONDS
for i in 0 1 2 3 4 5
do
    echo -e "${blue}Algorithm Code $i${clear}"
    for j in 1 2 4 8 16 32  
    do
        echo -e "\n${magenta}Testing ${j}Kints.txt${clear}"
        java Sorting ${j}Kints.txt $i
        #10 minutes Time Constraint. Since non of the programs up to 16K int will time out, this part is skipped. 
    done
   
    echo -e "\n${magenta}Testing 1MKints.txt${clear}"
    timeout 5 java Sorting 1Mints.txt $i #Modify the 5 to your desired time. Most use 10 as on the instructions, unit in seconds
    exit_status=$?

    if [[ $exit_status -eq 124 ]]; then
        echo -e "${red}Testing Timed out${clear}\n\n"
    else
         echo -e "${green}Testing Complete with No Timeout${clear}\n\n"
    fi
done

duration=$SECONDS - $start
echo "Total time elapsed:$duration"
