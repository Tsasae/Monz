import pandas as pd
from sklearn.feature_extraction.text import TfidfVectorizer
from sklearn.model_selection import train_test_split
from sklearn.naive_bayes import MultinomialNB
from sklearn.metrics import accuracy_score, classification_report

# Өгөгдөл бэлтгэх
data = pd.read_csv('mongolian_text_data.csv')  # Таны Монгол хэлний текст өгөгдөл агуулсан файл
X = data['text']  # Текст багана
y = data['label']  # Шошго багана

# Текстийг векторжуулах
vectorizer = TfidfVectorizer(stop_words=['ба', 'болон', 'гэх', 'тэгээд', 'энэ', 'тэр', 'байна', 'байх', 'юм', 'гэх мэт'])  # Монгол хэлний зогсох үгс
X = vectorizer.fit_transform(X)

# Сургалтын болон шалгалтын өгөгдөлд хуваах
X_train, X_test, y_train, y_test = train_test_split(X, y, test_size=0.2, random_state=42)

# Naive Bayes алгоритм ашиглан сургалт хийх
model = MultinomialNB()
model.fit(X_train, y_train)

# Урьдчилсан таамаглал хийх
y_pred = model.predict(X_test)

# Үр дүнг үнэлэх
print("Нарийвчлал:", accuracy_score(y_test, y_pred))
print("Ангиллын тайлан:\n", classification_report(y_test, y_pred))
