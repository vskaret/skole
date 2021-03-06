; Forelesning 4

; 1øk og erstatt 1
(define (replacer x y)
  (lambda (z)
    (if (= z x)
        y
        z)))

; søk og erstatt 2
(define (replacer2 pred proc)
  (lambda (z)
    (if (pred z)
        (proc z )
        z)))

; Uke 7 øvingsoppgaver

; 1.30
; pre info
(define (cube x) (* x x x))

(define (sum-integers a b)
  (if (> a b)
      0
      (+ a (sum-integers (+ a 1) b))))

(define (sum-cubes a b)
  (if (> a b)
      0
      (+ (cube a)
         (sum-cubes (+ a 1) b))))

(define (pi-sum a b)
  (if (> a b)
      0
      (+ (/ 1.0 (* a (+ a 2)))
         (pi-sum (+ a 4) b))))

;(define (sum term a next b)
;  (if (> a b)
;      0
;      (+ (term a)
;         (sum term (next a) next b))))

(define (inc n) (+ n 1))
(define (identity x) x)

; oppg
(define (sum term a next b)
  (define (iter a result)
    (if (> a b)
        result
        (iter (next a)
              (+ result (term a)))))
  (iter a 0))

; noen ting som går igjen ved "oversetting" av rekursiv->iterativ:
; - basistilfellet: returnere akkumulert resultat
; - basistilfellet ved rekursjon brukes som argument ved første kall ("hale-kallet")
; - rekursive kallet må i hale-posisjon og bygge på resultatet for hver iterasjon

; 1.31
; a
(define (product func start next stop)
  (if (> start stop)
      1
      (* (func start)
         (product func (next start) next stop))))
; b
(define (iproduct func start next stop)
  (define (iter x result)
    (if (> x stop)
        result
        (iter (next x) 
              (* result (func x)))))
  (iter start 1))


(define (fac x)
  (if (= x 1)
      1
      (* x (fac (- x 1)))))

(define (factorial x)
  (product identity 1 inc x))

(define (ifactorial x)
  (iproduct identity 1 inc x))


; 1.32
; a - abstrahert sum/produkt/etc prosedyre
(define (accumulate combiner null-value term a next b)
  (if (> a b)
      null-value
      (combiner (term a)
                (accumulate combiner null-value term (next a) next b))))

(define (accusum term a next b)
  (accumulate + 0 term a next b))

(define (accuproduct term a next b)
  (accumulate * 1 term a next b))
; b
(define (iccumulate combiner null-value term a next b)
  (define (iter a result)
    (if (> a b)
        result
        (iter (next a)
              (combiner (term a) result))))
  (iter a null-value))

; 1.34
; (f f)
; (f 2)
; (2 2)
; error ikke prosedyre

; 1.42
; utfører to prosedyrer på z
(define (compose proc1 proc2)
  (lambda (z) (proc1 (proc2 z))))

; reduce def
;(define (reduce proc init items)
;  (if (null? items)
;      init
;      (proc (car items)
;            (reduce proc init (cdr items)))))

(define (ireduce proc init items)
  (define (iter items result)
    (if (null? items)
        result
        (iter (cdr items)
              (proc (car items) result))))
  (iter items init))

; ekstraoppgave 1 (fra løsningsforslag, aner ikke hva som skjer)
(define (reduce f lst)
  (if (null? (cdr lst))
      (car lst)
      (f (car lst) (reduce f (cdr lst)))))

;(define (compose f g)
;  (lambda (x) (f (apply g x))))

(define (comp f . procs)
  (reduce compose (cons f procs)))

(define (range start stop)
    (define (iter b items)
      (if (< b start)
          items
          (iter (- b 1) (cons b items))))
    (iter stop '()))

; 1.43
; repeterer en prosedyre på z n ganger
(define (repeated-bad proc n)
  (lambda (z)
    (if (= n 1)
        (proc z)
        ((compose proc (repeated proc (- n 1))) z))))

(define (square x) (* x x))

(define (repeated proc n)
  (if (= 1 n)
      proc
      (compose proc (repeated proc (- n 1)))))

; 1.44
(define (average args)
  (/ (ireduce + 0 args)
     (length args)))

(define (my-average args)
  (define (sum lst)
    (if (null? lst)
        0
        (+ (car lst) (sum (cdr lst)))))
  (/ (sum args)
     (length args)))

(define dx 0.000001)
; returnerer en prosedyre som smoother f
(define (smooth proc)
  (lambda (x)
    (/ ( + (proc (- x dx))
           (proc x)
           (proc (+ x dx)))
       3)))

(define (smooth-n-fold proc n)
  ((repeated smooth n) proc))
; ((smooth (smooth square)) 5)
; ((smooth (smooth (smooth square))) 5)
; ((smooth (smooth (smooth (smooth square)))) 5)
; etc


; evig loop
(define (evig-sum . args)
  (display args) (newline)
  (if (null? args)
      0
      (+ (car args)
         (evig-sum (cdr args)))))

; (evig-sum 1 2 3 5 6 7)
; (+ 1 (evig-sum ((2 3 5 6 7)))
; (+ 1 (+ '()? evig-sum (())))
; (+ 1 (+ '()? (+ '()? evig-sum (()))))
; . args gjør alle argumentene til en liste, derfor
; det etter andre kjøring blir en liste med et element
; og (cdr (args)) henter ut den tomme listen

(define (sum . args)
  (display args) (newline)
  (if (null? args)
      0
      (+ (car args)
         (apply sum (cdr args)))))
; apply pakker ut alle elementene i listen for en prosedyre, eks:
; (apply + '(1 2 3 4)) -> 10
; (sum 1 2 3 5 6 7) -> 24


; accumulate2
(define (accumulate2 proc init lst)
  (if (null? lst)
      init
      (proc (car lst)
            (accumulate2 proc init (cdr lst)))))
; 2.33
(define (my-map p sequence)
  (accumulate2 (lambda (x y) (cons (p x) y)) '() sequence))

(define (my-append seq1 seq2)
  (accumulate2 cons seq2 seq1))

(define (my-length sequence)
  (accumulate2 (lambda (x y) (+ 1 y)) 0 sequence))

; 2.36
(define (accumulate-n proc init seqs)
  (if (null? seqs)
      '()
      (cons (accumulate2 proc init (car seqs))
            (accumulate-n proc init (cdr seqs)))))

; square
(define (square x) (* x x))

; 2.37
(define (dot-product v w)
  (accumulate2 + 0 (map * v w)))

; (map * '(1 2 3) '(4 5 6))
; (4 10 18)


; (matrix-*-vector '((1 2 3) (4 5 6)) '(7 8 9))
; (cons (dot-product '(1 2 3) '(7 8 9)) (dot-product '((4 5 6)) '(7 8 9))
; (cons (dot-product '(1 2 3) '(7 8 9)) cons (dot-product '(4 5 6) '(7 8 9)) (dot-product '() '(7 8 9)))

; (matrix-*-vector '((1 4 6) (2 5 7) (3 6 8) (4 6 9)) '(1 2 3))
; (dot-product '(1 4 6) '(1 2 3))
; (dot-product '(2 5 7) '(1 2 3))
; (dot-product '(3 6 8) '(1 2 3))
; (dot-product '(4 6 9) '(1 2 3))
(define (matrix-*-vector m v)
  (map (lambda (w) (dot-product w v)) m))

; feil
(define (transpose mat)
  (accumulate2 cons '() mat))

; (transpose '((1 2 3) (4 5 6)))
; ((1 4), (2 5), (3 6))


