; Uke 6
; 2.17
(define (last-pair lst)
  (if (null? (cdr lst))
      lst
      (last-pair (cdr lst))))


; 2.18
(define (my-reverse lst)
  (if (null? (cdr lst))
      (car lst)
      (cons (my-reverse (cdr lst))
            (car lst))))

(define (my-i-reverse lst)
  (define (iter in out)
    (if (null? in)
        out
        (iter (cdr in)
              (cons (car in) out))))
  (iter lst '()))


; 2.21
(define (square x) (* x x))

(define (square-list items)
  (if (null? items)
      '()
      (cons (square (car items))
            (square-list (cdr items)))))

(define (map-square-list items)
  (map square items))


; 2.22
; 1. Legger den første til i listen først og det blir dermed den siste siden
; alt blir conset forran
; 2. Nå vil den tomme listen være første element i cons-rekken og det vil dermed
; ikke være det siste elementet, altså ikke en liste.


; 2.23
(define (my-for-each proc lst)
  (if (null? lst)
      #t
      (begin (proc (car lst))
             (for-each proc (cdr lst)))))


; Uke 7
; 1.42
(define (compose proc1 proc2)
  (lambda (z) (proc1 (proc2 z))))


; 1.43
(define (repeated proc n)
  (if (= n 1)
      proc
      (compose proc (repeated proc (- n 1)))))


; 1.44
(define dx 0.00001)

(define (smooth f)
  (lambda (x)
    (/ (+ (- (f x) dx)
          (f x)
          (+ (f x) dx))
       3)))

; ((repeated smooth n) 5)
; ^feil
; ((repeated smooth n) f)

(define (smooth-n f n)
  ((repeated smooth n) f))


; 2.33
(define (accumulate comb init seq)
  (if (null? seq)
      init
      (comb (car seq)
            (accumulate comb init (cdr seq)))))

(define (my-map proc seq)
  (accumulate (lambda (x y) (cons (proc x) y)) '() seq))

(define (my-append seq1 seq2)
  (accumulate cons seq2 seq1))

(define (my-length seq)
  (accumulate (lambda (x y) (+ 1 y)) 0 seq))


; 2.27
; pre
(define (deep-copy lst)
  (cond ((null? lst) '())
        ((pair? (car lst))
         (cons (deep-copy (car lst))
               (deep-copy (cdr lst))))
        (else (cons (car lst)
                    (deep-copy (cdr lst))))))

(define (my-r-reverse lst)
  (if (null? lst)
      lst
      (append (my-r-reverse (cdr lst))
              (list (car lst)))))

(define (deep-reverse lst)
  (cond ((null? lst) lst)
        ((pair? (car lst))
         (append (deep-reverse (cdr lst))
                 (list (deep-reverse (car lst)))))    ; må appende på car-en for
        (else (append (deep-reverse (cdr lst))        ; der fjernes listestrukturen
                      (list (car lst))))))

(define (deep-i-reverse lst)
  (define (iter in out)
    (cond ((null? in) out)
          ((pair? (car in))
           (iter (cdr in)
                (cons (deep-i-reverse (car in)) out)))
          (else
           (iter (cdr in)
                 (cons (car in) out)))))
  (iter lst '()))


; 2.28
(define (fringe lst)
  ;(display lst) (newline)
  (cond ((null? lst) '())
        ((pair? (car lst))
         (append (fringe (car lst))
                 (fringe (cdr lst))))
        (else (display "car skal conses ") (display lst) (newline)
              (display (car lst)) (newline)
         (cons (car lst)
               (fringe (cdr lst))))))


; 2.30
(define (square-tree lst)
  (cond ((null? lst) '())
        ((pair? (car lst))
         (cons (square-tree (car lst))
               (square-tree (cdr lst))))
        (else (cons ((lambda (x) (* x x)) (car lst))
                     (square-tree (cdr lst))))))

; smartere å bruke number? fordi det er mer effektivt en pair?

(define (square-i-tree lst)
  (define (iter in out)
    (cond ((null? in) out)
          ((pair? (car in))
           (iter (cdr in)
                 (cons (car in) out)))
          (else (display out) (newline)
           (iter (cdr in)
                 (cons ((lambda (x) (* x x)) (car in))
                       out)))))
  (iter lst '()))


; 2.31 tree-map
(define (tree-map proc tree)
  (cond ((null? tree) '())
        ((number? (car tree))
         (cons (proc (car tree))
               (tree-map proc (cdr tree))))
        (else (cons (tree-map proc (car tree))
                    (tree-map proc (cdr tree))))))
  