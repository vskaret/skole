(define (filter pred lst)
  (cond ((null? lst) '())
        ((pred (car lst)) (cons (car lst)
                                (filter pred (cdr lst))))
        (else (filter pred (cdr lst)))))

(define (smeq? x)
  (lambda (z)
    (<= z x)))
(define (larg? x)
  (lambda (z)
    (> z x)))

; filter, append, første variabel i lista
(define (quicksort2 lst)
  (cond ((null? lst)'())
        ((append
          (quicksort (filter (smeq? (car lst)) (cdr lst)))
          (list (car lst))
          (quicksort (filter (larg? (car lst)) (cdr lst)))))))

; versjon med anonyme prosedyrer og if i stedet for cond
(define (quicksort lst)
  (if (null? lst)
      '()
      (append
       (quicksort (filter (lambda (z) (<= z (car lst))) (cdr lst)))
       (list (car lst))
       (quicksort (filter (lambda (z) (> z (car lst))) (cdr lst))))))