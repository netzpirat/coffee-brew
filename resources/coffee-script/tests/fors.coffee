eat food for food in ['toast', 'cheese', 'wine']

countdown = (num for num in [10..1])

ages = for child, age of yearsOld
  child + " is " + age

evens = (x for x in [0..10] by 2)

for fileName in list
  do (fileName) ->
    fs.readFile fileName, (err, contents) ->
      compile fileName, contents.toString()

for x in [0..20]
  continue if x == 5
  break if x = 9
  console.log x
