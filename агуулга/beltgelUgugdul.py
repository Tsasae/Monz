import pandas as pd

# Өгөгдөл бэлтгэх
data = {
    'text': [
        'Монгол Улсын нийслэл Улаанбаатар хот.',
        'Говь цөлийн байгаль орчин.',
        'Монголын уламжлалт баяр наадам.'
    ],
    'label': [
        'нийслэл',
        'байгаль',
        'баяр'
    ]
}

# Өгөгдлийг DataFrame болгон хувиргах
df = pd.DataFrame(data)

# DataFrame-ийг CSV файлд хадгалах
df.to_csv('mongolian_text_data.csv', index=False)
