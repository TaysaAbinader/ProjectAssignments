# Task 1

## Gather data
First, I would gather the data needed by getting a list of how many students are and the ages of them, and separate the quantity of students per age.

## Convert the count data into probabilities
After that, I should convert the quantity data into probabilities by dividing the amount of students on each age group by the total number of students.

## Build cumulative distribution
Then I should build a cumulative distribution by stacking the probabities on top of each other, so a probability range for each age group can be built.

## Draw random numbers between 0 and 1
Finally, I should draw random numbers between 0 and 1, and repeat the process 1000 times. It works because the chance of the random number to fall into each cumulative distribution interval is equal to the proportio of each age in the age group.

## Pseudo-code example

ages = [20, 21, 25, 30, 36, 39]

totalAmountStudents = 50

studentsPerAge = [5, 10, 10, 15, 5, 5]

ageProbabilities = []

cumulativeDistribution = []

ageSamples = []

Iterate through studentsPerAge

Divide each value by totalAmountStudents

Add the result to ageProbabilities

Iterate through ageProbabilities

Sum the values one by one throug a variable cdItem += item

Add each value on cumulativeDistribution

Create a loop to repeat 1000 times

Inside the loop:

* create a variable random = random(0, 1)

* Iterate through the cumulative distribution list, the random value can be compared with the cumulativeDistribution.

* when the random fits a cumulativeDistribution value, iterate through the ages list to find the age related to the cumulativeDistribution range.

* when the age is found add it to the ageSamples list.


