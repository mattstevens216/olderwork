
-- Assignment 4 Part II, CSCE-314 Sections 201 and 501
-- Instructor: Hyunyoung Lee
-- Section: PUT YOUR TEAM MEMBERS' SECTIONS (201 or 501) 501
-- Student Name: Matthew Stevens and Joshua Langley
-- UIN: 924000693 323005577
-- (Acknowledge any help received here)

module WParser ( parse, wprogram ) where

  import Data.Char
  import Control.Applicative (Applicative(..))
  import Control.Monad       (liftM, ap)
  import W

  -------------------
  -- keywords of W --
  -------------------
  keywords = words "var if else while print true false"
  isKeyword s = s `elem` keywords
    
  keyword s = do
    s' <- identifier
    if s' == s then return s else failure

  variable = do
    s <- identifier
    if isKeyword s then failure else return (Var s)

  -----------------------------
  -- This is the main parser --
  -----------------------------
  wprogram = whitespace >> many stmt >>= \ss -> return $ Block ss
  -- a program is a sequence of statements; the parser returns them
  -- as a single block-statement

  -- only two of the statement types below are already defined, 
  -- the rest are undefined.
  -- please implement them
  stmt = varDeclStmt +++ assignStmt +++ ifStmt +++ whileStmt +++ 
         blockStmt +++ emptyStmt +++ printStmt

  
  printStmt = do
    keyword "print"
    e <- expr
    symbol ";"
    return $ Print e

  emptyStmt = do 
    symbol ";" 
    return $ Empty


  varDeclStmt = do
    keyword "var" --keyword
    s <- identifier --identifier
    symbol "=" --symbol
    e <- expr --expr
    symbol ";"
    return $ (VarDecl s e) --s


  assignStmt = do
    s <- identifier -- parse an identifier and bind it to s          Entire Line
    symbol "="
    e <- expr -- parse an expression and bind it to e          Entire line
    symbol ";"
    return $ (Assign s e) --s


  blockStmt = do
    symbol "{"
    -- parse one or more statements and bind it to stmts
    m <- many stmt
    symbol "}"
    return $ (Block m)

    
  ifStmt = ( do
    keyword "if" -- parse a keyword "if"                           ENTIRE LINE
    cond <- parens expr-- parse a parenthesized expr and bind it to cond          ENTIRE LINE
    s1 <- stmt  -- parse a statement and bind it to s1                 ENTIRE LINE
    keyword "else"  -- parse a keyword "else"                           ENTIRE LINE
    s2 <- stmt     -- parse a statement and bind it to s2            ENTIRE LINE
    return $ (If cond s1 s2)  -- EMTPY
    ) +++ ( do  -- choice parser
    keyword "else"  -- parse a keyword "if"         ENTIRE LINE
    cond <- parens expr-- parse a parenthesized expr and bind it to cond   ENTIRE LINE
    s1 <- stmt -- parse a statement and bind it to s1    ENTIRE LINE
    return $ Empty-- else part is Empty   EMPTY
    )


  whileStmt = do
    keyword "while" -- parse a keyword "while"    ENTIRE LINE
    cond <- parens expr-- parse a parenthesized expr and bind it to cond   ENTIRE LINE
    s <- stmt -- parse a statement and bind it to s     ENTIRE LINE
    return $ (While cond s) --    

	
  expr = logicExpr >>= logicExprSeq
  
  logicExprSeq left = (do
    op <- (symbol "||" >> return Or) +++ (symbol "&&" >> return And)
    right <- logicExpr
    logicExprSeq (op left right)
    ) +++ return left
	
  logicExpr = (symbol "!" >> logicExpr >>= \x -> return (Not x)) +++ (comparisonExpr >>= \x -> return x)

  comparisonExpr = arithmeticExpr >>= comparisonExprSeq
  
  comparisonExprSeq left = (do
    op <- (symbol "==" >> return Equals) +++ (symbol "!=" >> return NotEqual) +++ (symbol ">" >> return Greater) +++ (symbol ">=" >> return GreaterOrEq) +++ (symbol "<" >> return Less) +++ (symbol "<=" >> return LessOrEq)
    right <- arithmeticExpr
    comparisonExprSeq (op left right)
    ) +++ return left
	
  arithmeticExpr = term >>= termSeq
  
  termSeq left = (do
    op <- (symbol "+" >> return Plus)
    right <- term
    termSeq (op left right)
    ) +++ return left

  term = factor >>= factorSeq
  
  factorSeq left = (do
    op <- (symbol "*" >> return Mult)
    right <- factor
    factorSeq (op left right)
    ) +++ return left
  
  factor = (nat >>= \n -> return (Val (VInt n))) +++ (identifier >>= \n -> return $ Var n) +++ stringLiteral +++ parens expr +++ bool

  bool = (do
    keyword "True"
    return (Val (VBool True))
    ) +++ (do
    keyword "False"
    return (Val (VBool False))
    )

  -- stringLiterals can contain '\n' characters
  stringLiteral = do char ('"') 
                     s <- many stringChar
                     char ('"')
                     whitespace
                     return $ Val (VString s)

  stringChar = do ( char '\\' >> char 'n' >> return '\n' ) 
               +++ sat (/= '"')

  ----------------------
  -- Parser utilities --
  ----------------------

  newtype Parser a = P (String -> [(a, String)])
    
  parse :: Parser a -> String -> [(a, String)]
  parse (P p) inp = p inp
    
  instance Monad Parser where
      -- return :: a -> Parser a
      return v = P $ \inp -> [(v, inp)]
    
      -- (>>=) :: Parser a -> (a -> Parser b) -> Parser b
      p >>= q = P $ \inp -> case parse p inp of 
                              [] -> []
                              [(v, inp')] -> let q' = q v in parse q' inp'
    
  instance Functor Parser where
    fmap = liftM

  instance Applicative Parser where
    pure = return
    (<*>) = ap

  -- failure parser
  failure :: Parser a
  failure = P $ \_ -> []
  
  -- item parser 
  item :: Parser Char 
  item = P $ \inp -> case inp of 
                       (x:xs) -> [(x, xs)]
                       [] -> []
    
  -- choice parser (+++) -- parse with p or q
  (+++) :: Parser a -> Parser a -> Parser a
  p +++ q = P $ \inp -> case parse p inp of 
                          [] -> parse q inp
                          [(v, inp')] -> [(v, inp')]
    
    
  -- some simple helper parsers
  sat :: (Char -> Bool) -> Parser Char
  sat pred = do c <- item 
                if pred c then return c else failure
    
  digit, letter, alphanum :: Parser Char
  digit = sat isDigit
  letter = sat isAlpha
  alphanum = sat isAlphaNum
    
  char :: Char -> Parser Char
  char x = sat (== x)
    
  string = sequence . map char 
    
  many1 :: Parser a -> Parser [a]
  many1 p = do v <- p 
               vs <- many p 
               return (v:vs)
    
  many :: Parser a -> Parser [a]
  many p = many1 p +++ return []
    
  -- Useful building blocks
  nat :: Parser Int
  nat = do s <- many1 digit 
           return (read s)
    
  identifier :: Parser String
  identifier = do s <- letter
                  ss <- many alphanum
                  whitespace
                  return (s:ss)

  whitespace :: Parser ()
  whitespace = many (sat isSpace) >> comment
    
  symbol s = do 
    s' <- string s
    whitespace
    return s'    
    
  comment = ( do string "//" 
                 many (sat (/= '\n')) 
                 whitespace ) +++ return ()
  parens p = do 
    symbol "("
    p' <- p
    symbol ")"
    return p'


