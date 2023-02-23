
-- Assignment 3, CSCE-314
-- Section: PUT YOUR SECTION (201 or 501) 501
-- Student Name: Matthew Stevens
-- UIN: 924000693
-- (Acknowledge any help received here) Nick Wong, Joshua (not sure about his last name), Rob (not sure about his last name) were all vocal references

module Main where

import Test.HUnit
import System.Exit
import Data.List
import Data.Char


---- Part 1.
-- Problem 1
perfects :: Int -> [Int]
factors n = sum [x| x <- [1..n], n `mod` x == 0, x /= n]
perfects n = [x| x<- [1..n], factors x == x]

-- Problem 2
scalarproduct :: [Int] -> [Int] -> Int
scalarproduct _ [] = 0
scalarproduct (x:xs) (y:ys) = sum[x*y] + scalarproduct xs ys

---- Part 2.
-- Problem 3
mergeBy :: (a -> a -> Bool) -> [a] -> [a] -> [a]
mergeBy compare [] ys = ys
mergeBy compare xs [] = xs
mergeBy compare (x:xs) (y:ys) | compare x y = x:mergeBy compare xs (y:ys)
                          | otherwise = y:mergeBy compare (x:xs) ys

msortBy :: (a -> a -> Bool) -> [a] -> [a]
msortBy q [] = []
msortBy q [x] = [x]
msortBy q len = mergeBy q (msortBy q xs) (msortBy q ys)
   where (xs, ys) = split len

split :: [a] -> ([a], [a])
split [] = ([], [])
split [x] = ([x], [])
split (x:y:xzs) = (x:xs,(y:ys))
   where (xs, ys) = split xzs
   
mergeSort :: Ord a => [a] -> [a]
mergeSort = msortBy (<)


-- Problem 4
multiply :: [Int] -> Int
multiply [] = 1
multiply xs = foldr (*) 1 xs

-- Problem 5
concatenate :: [String] -> String 
concatenate = foldl1 (++) 

-- Problem 6
concatenateAndUpcaseOddLengthStrings :: [String] -> String
concatenateAndUpcaseOddLengthStrings = concatenate . (map (map toUpper)) . filter (\str -> odd (length str))

-- Problem 7
myInsert :: Ord a => a -> [a] -> [a]
myInsert x [] = [x]
myInsert x l@(y:ys) | x <= y = x : l
                    | otherwise = y : myInsert x ys

insertionSort :: Ord a => [a] -> [a]
insertionSort = foldr myInsert []

-- Problem 8
maxElem :: Ord a => [a] -> a 
maxElem = foldr1 max

---- Part 3.
data Tree a b = Branch b (Tree a b) (Tree a b)
              | Leaf a

-- Problem 9
instance (Show a, Show b) => Show (Tree a b) where
   show t = showInd "" t
    where showInd pre (Leaf x) = pre ++ show x ++ "\n"
          showInd pre (Branch x l r) =
            pre ++ (show x) ++ "\n" ++
            showInd (pre ++ "  ") l ++
            showInd (pre ++ "  ") r

-- Problem 10
preorder  :: (a -> c) -> (b -> c) -> Tree a b -> [c]
preorder p q (Leaf x) = [p x]
preorder p q (Branch x l r) = q x : (preorder p q l ++ preorder p q r)

inorder   :: (a -> c) -> (b -> c) -> Tree a b -> [c]
inorder p q (Leaf x) = [p x]
inorder p q (Branch x l r) = inorder p q l ++ [q x] ++ inorder p q r

---- Part 4. 
data E = IntLit Int
       | BoolLit Bool
       | Plus E E    -- for addition
       | Mult E E    -- for multiplication
       | Equals E E
         deriving (Eq, Show)

-- Problem 11
eval :: E -> E
eval c@(IntLit i) = c
eval c@(BoolLit b) = c

eval (Plus (BoolLit a) _) = error ("attempt of addition with a bool")
eval (Plus _ (BoolLit a)) = error ("attempt of addition with a bool")
eval (Plus (IntLit a) (IntLit b)) = (IntLit (a+b))
eval (Plus (a) (b)) = eval (Plus (eval a) (eval b))

eval (Mult (BoolLit a) _) = error ("attempt of mult of bool")
eval (Mult _ (BoolLit a)) = error ("attempt of mult of bool")
eval (Mult (IntLit a) (IntLit b)) = (IntLit (a*b))
eval (Mult (a) (b)) = eval (Mult (eval a) (eval b))

eval (Equals (BoolLit a) (BoolLit b)) = (BoolLit (a==b))
eval (Equals (IntLit a) (IntLit b)) = (BoolLit (a==b))
eval (Equals (a) (b)) = eval (Equals (eval a) (eval b))

mytree = Branch "A" 
           (Branch "B" 
              (Leaf 1) 
              (Leaf 2)) 
           (Leaf 3)

prog1 = Equals 
           (Plus (IntLit 1) (IntLit 9))
           (Mult
              (IntLit 5)
              (Plus (IntLit 1) (IntLit 1)))

prog2 = Equals
           (Equals
              (Mult (IntLit 4) (IntLit 2))
              (Plus (IntLit 5) (Mult (IntLit 2) (IntLit 1))))
           (Equals (BoolLit True) (BoolLit True))

    
myTestList =

  let te s e a = test $ assertEqual s e a
      tb s b = test $ assertBool s b
  in
    TestList [ 
        tb "perfects" $ (perfects 500) == [6,28,496]
      , tb "scalarproduct" $ (scalarproduct [1,2,3][4,5,6]) == 32

      , te "mergeBy 1" "GFEDBA" (mergeBy (>) "FED" "GBA")
      , te "mergeBy 2" "HMaouiwdy" (mergeBy (<) "Howdy" "Maui")
      
      , te "msortBy 1" " 'eggim" (msortBy (<) "gig 'em") 
      , te "msortBy 2" "nmlkieecbbaJ  " (msortBy (>) "Jack be nimble")
      , te "msortBy 3" "" (msortBy (<) "")
      
      , te "mergeSort 1" " adhllowy" (mergeSort "howdy all") 
      , te "mergeSort 2" "" (mergeSort "") 
      , te "mergeSort 3" "x" (mergeSort "x") 

      , te "multiply" 10 (multiply [-2, -1, 5])
      
      , te "concatenate" "ABCD" (concatenate ["AB", "", "", "C", "D", ""])

      , te "concatenateAndUpcaseOddLengthStrings"
          "HERE'S AN EXAMPLE" (concatenateAndUpcaseOddLengthStrings ["here's ", "an ", "a ", "example"])

      , te "myInsert 1" "How are you?" (myInsert 'o' "Hw are you?")
      , te "myInsert 2" "abcdefg" (myInsert 'c' "abdefg")
      , te "insertionSort" "  Jabcceikkqu" (insertionSort "Jack be quick")
      
      , te "max in a list" 200 (maxElem [3, 10, 200, 42])

      , te "preorder" "AB123" (concatenate (preorder show id mytree))
      , te "inorder" "1B2A3" (concatenate (inorder show id mytree))

      , te "eval1" (BoolLit True) (eval prog1)
      , te "eval2" (BoolLit False) (eval prog2)
      ]

main = do c <- runTestTT myTestList
          putStrLn $ show c
          let errs = errors c
              fails = failures c
          exitWith (codeGet errs fails)
          
codeGet errs fails
 | fails > 0       = ExitFailure 2
 | errs > 0        = ExitFailure 1
 | otherwise       = ExitSuccess
