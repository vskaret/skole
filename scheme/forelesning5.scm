; mengder

(define (element-of-set? x set)
  (cond ((null? set) #f)
        ((= x (car set)) #t)
        (else (element-of-set? x (cdr set)))))

(define (adjoin-set x set)
  (if (element-of-set? x set)
      set
      (cons x set)))

(define (union-set set1 set2)
  (cond ((null? set2) set1)
        ((not (element-of-set? (car set2) set1))
         (union-set (adjoin-set (car set2) set1)
                           (cdr set2)))
        (else (union-set set1 (cdr set2)))))

(define (intersection-set set1 set2)
  (cond ((null? set1) '())                    ; <- ((or (null? set1) (null? set2)) '())
        ((element-of-set? (car set1) set2)    ; ^  hvis en av de er tomme så
            (cons (car set1)                  ; ^  må snittet også være tomt
                  (intersection-set (cdr set1) set2)))
        (else (intersection-set (cdr set1) set2))))

; element-of-set og adjoin-set har i værste fall O(n) kompleksitet
; intersection-set og union-set involverer sjekk av medlemskap for hvert element i en
; mengde mot en annen: O(n^2) for to lister med n elementer

; ønsker å gjøre implementasjonen mer effektiv, eks ved bare tall kan man sortere
; mengden med minste tall først og så største tall til slutt

; ny implementasjon:
(define (new-element-of-set? x set)
  (cond ((null? set) #f)
        ((= x (car set)) #t)
        ((< x (car set)) #f)
        (else (new-element-of-set? x (cdr set)))))
; fortsatt teoretisk (worst case) O(n) vekst (i tilfellet x er siste element i set)
; men i praksis kan vi regne med at antall trinn i snitt vil være n/2

(define (new-intersection-set set1 set2)
  (if (or (null? set1 (null? set2)))
      '()
      (let ((x1 (car set1))
            (x2 (car set2)))
        (cond ((= x1 x2) (cons x1
                               (new-intersection-set (cdr set1)
                                                     (cdr set2))))
              ((< x1 x2) (new-intersection-set (cdr set1) set2))
              ((< x2 x1) (new-intersection-set set1 (cdr set2)))))))
; antall trinn er i værste fall proporsjonalt med summen av lengdene på listene (i stedet for produktet)
; O(n) vekst i stedet for O(n^2) (lineaær i stedet for kvadratisk)

; enda bedre å representere mengder som et binærtre med ordnede noder
; hver node lagrer:
; - et element
; - en venstregren med mindre elementer
; - en høyregren med større elementer
; ved søk etter et gitt element x:
; - hvis x er mindre enn nodeverdien søk til venstre
; - hvis x er større, søk til høyre
; dette kan halvere søkerommet i hvert trinn: logaritmisk vekst O(log n)

; abstraksjonsbarriere (implementasjon av trær):
(define (make-tree entry left right)   ; entry er verdien til noden
  (list entry left right))

(define (entry tree)
  (car tree))

(define (left-branch tree)
  (cadr tree))

(define (right-branch tree)
  (caddr tree))


; ny mengdeimplementasjon
(define (log-element-of-set? x set)
  (cond ((null? set) #f)
        ((= x (entry set)) #t)
        ((< x (entry set))
         (log-element-of-set? x (left-branch set)))
        ((> x (entry set))
         (log-element-of-set x (right-branch set)))))

(define (log-adjoin-set x set)
  (cond ((null? set) (make-tree x '() '()))
        ((= x (entry set)) set)
        ((< x (entry set))
         (make-tree (entry set)
                    (log-adjoin-set x (left-branch set))   ; rekursjon nedover i venstregren
                    (right-branch set)))
        ((> x (entry set))
         (make-tree (entry set)
                    (left-branch set)
                    (adjoin-set x (right-branch set))))))  ; rekursjon nedover i høyregren

; at abstraksjonsbarrieren lekker betyr at noe "innside-informasjon" synes,
; altså at ikke alle designvalgene blir skjult
; burde hatt et predikat empty-tree? i stedet for å bruke null? - med null? så ser vi at det
; er lister som brukes
; + empty-tree konstant eller (make-leaf x) prosedyre i stedet for (make-tre x '() '()) 