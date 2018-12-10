regExps = {
"exercise_1": /[A-Z][a-z]+/,
"exercise_2": /088[1578]\d{6}/,
"exercise_3": /[^01]+/,
"exercise_4": /^[A-Za-z]([^!@#$%^&*()]{2,})$/,
"exercise_5": /^([0-9]{1,3}|1[0-4]\d{2}|1500)$/,
"exercise_6": /class=['"](.*)['"]/
};
cssSelectors = {
"exercise_1": "item > java",
"exercise_2": "different > java",
"exercise_3": "item > java > tag",
"exercise_4": "css > item:nth-child(3)",
"exercise_5": "tag > java:nth-child(2)",
"exercise_6": "item#someId > item > item > item > item",
"exercise_7": "different > different#diffId2 > java:last-child",
"exercise_8": "css > item:nth-child(2)"
};
