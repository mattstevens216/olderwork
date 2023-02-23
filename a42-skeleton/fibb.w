  fibonacci x = asInt(eval (Var "r") (exec (fibonacciTest) [("r",(VInt 0 )), ("n",(VInt x))]))
  fibonacciTest = Block
  [
    VarDecl "afk" (Val (VInt 0)),
    VarDecl "b" (Val (VInt 0)),
    VarDecl "c" (Val (VInt 1)),
    While (Less (Var "afk") (Var "n"))
    (
      Block
      [ Assign "r" (Plus (Var "b") (Var "c")),
        Assign "b" (Var "c"),
        Assign "c" (Var "r"),
        Assign "afk" (Plus (Var "afk") (Val (VInt 1)))
      ]
    )
  ]
 