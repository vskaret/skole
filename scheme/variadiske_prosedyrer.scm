; variadiske prosedyrer - prosedyrer med variabelt antall argumenter
; (fra slutten av forelesning 5)

(define (sum . args)                ; samler args i en liste
  (define (recurse list)            ; jobber seg gjennom listen og plusser sammen
    (if (null? list)
        0
        (+ (car list)
           (recurse (cdr list)))))
  (recurse args))

; (sum 1 2 3) -> 6

(define (sum2 . args)
  (if (null? args)
      0
      (+ (car args)
         (sum2 (car args)))))

; funker ikke fordi noe blir samlet opp og det blir evig rekursjon
; se siste par minuttene av forelesningen på nytt