; søk og erstatt funksjon v1
(define (make-replace x y)
  (lambda (z)
    (if (= z x)
        y
        z)))
; (map (make-replace 5 8) '(5 5 5))

; v2
(define (make-replacer pred proc)
  (lambda (z)
    (if (pred z)
        (proc z)
        z)))

(define (square x) (* x x))
; ((make-replacer odd? square) 9)
; (map (make-replacer odd? square) '(1 2 3 4 5 6 7 8 9))

; reduce remake
(define (reduce proc init items)
  (if (null? items)
      init
      (proc (car items)
            (reduce proc init (cdr items)))))
; (reduce + 0 (map (make-replacer odd? square) '(1 2 3 4 5)))
; (+ 1 2 9 4 25)