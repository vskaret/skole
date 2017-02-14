; 2.22
(define square
  (lambda (x) (* x x)))

(define (square-list items)
  (define (iter things answer)
    (if (null? things)
        answer
        (iter (cdr things)
              (cons (square (car things))
                    answer))))
  (iter items '()))

; (square-list '(3 4 5 6))
; (iter '(3 4 5 6) '())
; (iter '(4 5 6) '(9)
; (iter '(5 6) '(16 9) '())
; (iter '(6) '(25 16 9)
; (iter '() (36 25 16 9)
; (36 25 16 9)

; løsningsforslag: Når vi bygger opp en liste iterativt vil alltid det som
; legges inn først ende opp sist, siden vi jobber med en først-inn-sist-ut
; liste.

(define (square-list2 items)
  (define (iter things answer)
    (if (null? things)
        answer
        (iter (cdr things)
              (cons answer
                    (square (car things))))))
  (iter items '()))

; (square-list2 '(3 4 5 6))
; (iter '(4 5 6) '('() . 9)
; (iter '(5 6) '(('() . 9) . 16)
; (iter '(6) '((('() . 9) . 16) . 25)
; (iter '() '(((('() . 9) . 16) . 25) . 36)
; '(((('() . 9) . 16) . 25) . 36)

; løsningsforslag: returnerer ikke en liste fordi (square (car things)) blir
; lagt til i slutten og det er ikke '(). Definisjonen av liste sier at det er
; en rekke med par som slutter med '().

; 2.23
