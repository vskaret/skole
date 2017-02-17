; 2.17
(define (last-pair1 items)
  (define (iter count items)
    (if (= (length items) 1)
        items
        (iter (length (cdr items)) (cdr items))))
  (iter 0 items))

; løsningsforslag
(define (last-pair items)
  (if (null? (cdr items))
      items
      (last-pair (cdr items))))

; 2.18
(define (remove-last items)
  (if (null? (cdr items))
      '()
      (cons (car items) (remove-last (cdr items)))))
  
(define (reverse2 items)
  (if (null? items)
      '()
      (cons (car (last-pair items))
            (reverse2 (if (null? (cdr items))
                          '()
                          (remove-last items))))))

(define (reverse3 items)
  (define (removelast items)
    (if (null? (cdr items))
        '()
        (cons (car items) (removelast (cdr items)))))
  (if (null? items)
      '()
      (cons (car (last-pair items)) (reverse3 (removelast items)))))
         
; 2.21
(define (square x)
  (* x x))

(define (square-list1 items)
  (if (null? items)
      '()
      (cons (square (car items)) (square-list1 (cdr items)))))

(define (square-list2 items)
  (map square items))


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
(define (for proc items)
  (if (null? items)
      #t
      (begin (proc (car items))
        (for proc (cdr items)))))

; løsningsforslag:
(define (for2 proc lst)
  (cond ((null? lst) 'ok)
        (else (proc (car lst))
              (for-each proc (cdr lst)))))

; Her kunne vi brukt if istedet, men da måtte vi omsluttet else-grenen med
; begin, siden if forventer nøyaktig tre argumenter. I cond er hver gren
; representert som en liste, der første i lista avgjør om resten av lista skal
; evalueres, og der resten av lista kan være vilkårlig lang, som betyr at begin
; er implisitt i cond. 

; 2.54
(define (quale? list1 list2)
  (define (iter list1 list2 equal)
    (cond ((and (null? list1) (null? list2)) #t)
          ((if (not equal) #f)
          (if (eq? (car list1) (car list2))
              (iter (cdr list1) (cdr list2) #t)
              #f))))
  (iter list1 list2 #t))

(define (qualee? list1 list2)
  (define (iter list1 list2)
    (cond ((and (null? list1) (null? list2)) #t)
          ((not (eq? (car list1) (car list2))) #f)
          ((eq? (car list1) (car list2)) (iter (cdr list1) (cdr list2)))))
  (iter list1 list2))

(define (elaque? list1 list2)
  (cond ((and (null? list1) (null? list2)) #t)
        ((not (eq? (car list1) (car list2))) #f)
        ((eq? (car list1) (car list2)) (elaque? (cdr list1) (cdr list2)))))

; løsningsforslag:
(define (equalz? a b)
  (or (eq? a b)
      (and (pair? a) (pair? b)
           (equal? (car a) (car b))
           (equal? (cdr a) (cdr b)))))
; må også dekke tilfellene der input ikke er lister
