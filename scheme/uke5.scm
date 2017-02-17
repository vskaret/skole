#lang r5rs

; 1.4
(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

; Hvis det andre argumentet (b) er større enn 0 vil prosedyren addere a og b,
; hvis b er mindre enn null vil prosedyren subtrahere b fra a. Altså vil
; det alltid bli a + |b|


; 1.5
(define (p) (p))

(define (test x y)
  (if (= x 0)
      0
      y))

(test 0 (p))

; Med applicative order evaluering så vil man få evighetsloop, mens i normal-
; order evaluering vil det bli skrevet ut 0. Dette er fordi i normal-order så
; blir ikke uttrykkene som ikke er med i en utregning evaluert. I applicative-
; order blir alt evaluert.


; 1.6
(define (new-if predicate then-clause else-clause)
  (cond (predicate then-clause)
        (else else-clause)))

; Løsningsforslag: Siden new-if er en prosedyre vil alle argumentene til new-if
; evalueres. sqrt-iter vil dermed kalles uavhengig av om good-enough? returnerer
; sant eller usant. Derfor vil ethvert kall på prosedyren forårsake et rekursivt
; kall, og den vil derfor ikke terminere. 


; 1.9
(define (+ a b)
  (if (= a 0)
      b
      (inc (+ (dec a) b))))
; (+ 4 5)
; (inc (+ (dec 4) 5))
; (inc (+ 3 5))
; (inc (inc 2 5))
; (inc (inc (inc 1 5)))
; (inc (inc (inc (inc 0 5))))
; (inc (inc (inc 0 6)))
; (inc (inc (0 7))
; (inc 0 8)
; 9
; Rekursiv prosess

(define (+ a b)
  (if (= a 0)
      b
      (+ (dec a) (inc b))))
; (+ 4 5)
; (+ (dec 4) (inc 5))
; (+ 3 6)
; (+ 2 7)
; (+ 1 8)
; (+ 0 9)
; 9
; Iterativ prosess