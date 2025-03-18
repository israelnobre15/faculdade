from modules.base64 import Base64

print(
    Base64.encoder(
        "abcdefghijklmnopqrstuvwxyz139312903u128d9uashd12u3bwiudbsahdb u9he921he18c9e9u12hewquidbquwddada"
    )
)
print(
    Base64.decoder_string(
        "YWJjZGVmZ2hpamtsbW5vcHFyc3R1dnd4eXoxMzkzMTI5MDN1MTI4ZDl1YXNoZDEydTNid2l1ZGJzYWhkYiB1OWhlOTIxaGUxOGM5ZTl1MTJoZXdxdWlkYnF1d2RkYWRh"
    )
)
