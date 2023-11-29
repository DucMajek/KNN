# KNN (k-nearest-neighbors)

Klasyfikator **KNN (k-nearest neighbors)** to prosty, ale skuteczny algorytm uczenia maszynowego, który opiera się na klasyfikacji obserwacji na podstawie najbliższych sąsiadów z określonego zbioru treningowego. Ten program został stworzony w celu dostarczenia klasyfikacji KNN dla zadanego zbioru treningowego i testowego.

## Argumenty

Program przyjmuje następujące argumenty:

- **k:** Dodatnia liczba naturalna, będąca hiperparametrem klasyfikatora KNN.
- **train-set:** Nazwa pliku zawierającego zbiór treningowy w formie pliku CSV umieszczonego w pliku tekstowym.
- **test-set:** Nazwa pliku zawierającego zbiór testowy w formie pliku CSV umieszczonego w pliku tekstowym.
## Program ma:
- Dokonać klasyfikacji k-NN wszystkich obserwacji z pliku test-set na podstawie pliku train-set oraz podać dokładność (accuracy) tej klasyfikacji.
- Dostarczać testowy interfejs (niekoniecznie graficzny), który umożliwia (zapętlone) podawanie przez użytkownika pojedynczych wektorów do klasyfikacji i podaje ich etykietę k-NN na podstawie train-set.
