;; lengde/length
(define (lengde l n)
  (if (null? l)
      n
      (lengde (cdr l) (+ n 1))))

(define (lengdee l)
  (if (null? l)
      0
      (+ 1 (lengdee (cdr l)))))



(define (mlengde l)
  (define (iter n)
    (if (null? l)
        n
        (lengde (cdr l) (+ n 1))))
  (iter 0))

(define liste (list 1 2 3 4))

;; square-all
(define (square-all items)
  (define (square x)
    (* x x))
  (if (null? items)
      '()
      (cons (square (car items)) (square-all (cdr items)))))

;; abs-all
(define (abs-all items)
  (define (abz x)
    (if (< x 0)
        (- x)
        x))
  (if (null? items)
      '()
      (cons (abz (car items)) (abs-all (cdr items)))))

;; dot-product
(define a '(2 1 3))
(define b '(1 3 0))

(define (dot-product v1 v2)
  (if (null? v1)
  0
  (+ (* (car v1) (car v2))
     (dot-product (cdr v1) (cdr v2)))))

;; reduce
(define (reduce proc init items)
  (if (null? items)
      init
      (proc (car items)
            (reduce proc init (cdr items)))))

