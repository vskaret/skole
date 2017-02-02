#lang r5rs

; 1.4
(define (a-plus-abs-b a b)
  ((if (> b 0) + -) a b))

; Hvis det andre argumentet (b) er større enn 0 vil prosedyren addere a og b,
; hvis b er mindre enn null vil prosedyren subtrahere b fra a.