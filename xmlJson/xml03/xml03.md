# <center>Exercise XML.03 – XPath & XQuery</center>
# General
All tasks are based on the provided sample data file ’recipes.xml’. You only have to provide your XPath/XQuery statement, not the results.
# 1 XPath
1. Select all recipe titles.
2. Select the node for recipe ’Linguine Pescadoro’.
3. Select all preparation steps of ’Ricotta Pie’ without ingredient preparation steps.
4. Select all preparation steps of all ’Ricotta Pie’ ingredients without those preparation steps
of the final recipe.
5. Select the ingredients of the dough for ’Ricotta Pie’ which have an amount > 1.
6. Select the nutritional value (calories) of ’Zuppa Inglese’.
7. Select the last step for the ’Linguine Pescadoro’ preparation (not of the pepper).
8. Select the names of those recipe ingredients which have ingredients themselves.
    - Only the top layer
    - Duplicate names are ok (distinct is available starting with XPath 2.0, but you can just
    ignore it)
- Hint: ∗[ingredient ]

## Result
```xq
(:XPATH:)
(:1:)
(://title:)
(:2:)
(://recipe[title="Linguine Pescadoro"]:)
(:3:)
(://recipe[title="Ricotta Pie"]/ingredient/preparation:)
(:4:)
(://recipe[title="Ricotta Pie"]/ingredient/preparation:)
(:5:)
(://recipe[title="Ricotta Pie"]/ingredient[@name = "dough"]/ingredient[@amount>1]:)
(:6:)
(://recipe[title="Zuppa Inglese"]/nutrition/@calories:)
(:7:)
(://recipe[title="Linguine Pescadoro"]/preparation/step[last()]:)
(:8:)
(:distinct-values(//ingredient[ingredient]):)
```

# 2 XQuery
To use ’functx’ functions (which you’ll probably need) you need to import module namespace functx = ’http://www.functx.com’;.
1. Select title and calories of each recipe.
2. Select those preparation steps of ’Zuppa Inglese’ which have more than 1 line of text.
- Hint: remember that the data source can be any XPath expression
3. Select the sum of all fat values (from the nutrition element) of all recipes which have a
protein nutrition value above 20.
4. Select from the sauce ingredient of ’Linguine Pescadoro’ those ingredient which are measured
in ’teaspoon’ and have an amount of at least 1. Return name and amount.

## Result
```xq
(:1:)
(:for $r in //recipe
return ($r/title, $r/nutrition/@calories):)

(:2:)
(:import module namespace functx = "http://www.functx.com" at "http://www.xqueryfunctions.com/xq/functx-1.0-doc-2007-01.xq";


for $r in //recipe[title="Zuppa Inglese"]/preparation
where functx:line-count($r/step) > 1
return $r:)

(:3:)
(:for $r in //recipe
where $r/nutrition/@protein > 20
return $r/nutrition/@fat:)

(:4:)
(:for $i in //recipe[title="Linguine Pescadoro"]//ingredient[@unit="tablespoon", @amount>1]
return $i:)

(:for $i in //recipe[title="Linguine Pescadoro"]//ingredient
where $i/@unit="tablespoon" and $i/@amount > 1
return $i:)

```