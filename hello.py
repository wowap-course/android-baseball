text = "Life is too short, You need python."

d = dict()
for c in text:
    if c not in d:
        d[c] = 1
    else : 
        d[c] += 1

print(d)