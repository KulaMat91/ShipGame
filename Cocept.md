
DESCRIPTION
1. Game board - 2 boards - 10 x 10 (future other size of board) 
Tworzenie dwóch tablic dla każdego gracza(czyli 4 ogólnie) 10 na 10 pól, od A do J i od 1 do 10.
2. 2 Players (future player vs AI) 
Gracze wybierają miejsce położenia swoich statków na planszy, statki nie moga:
- nachodzić na siebie, 
- stykać się ze sobą, 
- wychodzić poza planszę.
3. Ship (difference sizes) 5x(1x1), 4x(2x1), 3x(3x1), 2x(4x1), 1x(5x1) 
Staki mają różne rozmiary, jedno pole to jedno życie.
4. Game mechanics 
Gracze po kolei wybierają pola przeciwnka określająć liczbę i literę na planszy. 
W momencie trafienia w statek przeciwnika gracz gra dalej, w przeciwnym wypadku kończy turę.
Gra toczy się do zlikwidowania wszystkich statków.
Komunikaty w trakcie trafienia : 
- trafiony - zaznaczone pole 1,
- trafiony zatopiony,
- pudło - zaznaczone pole 0.
Sprawdzenie czy gracz ma wszystkie statki zatopione - liczba jedynek jest równa długości wszystkich statków.


Class List 
1. Game board
a) Player board
b) Enemy board
2. Player
a) Player 1
b) Player 2 
3. Ship
a) 5x(1x1),
b) 4x(2x1), 
c) 3x(3x1), 
d) 2x(4x1), 
c) 1x(5x1).
4. Game logic
5. Persistence layer


LISTA FEATURE'ÓW:
1. Game board - (board 10x10)
2. 