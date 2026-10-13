package com.rekha;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ValidasiPendaftaranTest {

    // --- 1. FUNGSI LOGIKA VALIDASI (KODE ASLI YANG DIUJI) ---
    public String validasiPendaftaran(String nama, int umur, String email, boolean setujuSyarat) {
        if (nama == null || nama.isEmpty()) {
            return "Nama harus diisi";
        }
        if (umur < 17) {
            return "Umur minimal 17 tahun";
        }
        if (email == null || !email.contains("@")) {
            return "Email tidak valid";
        }
        if (!setujuSyarat) {
            return "Harus menyetujui syarat dan ketentuan";
        }
        return "Pendaftaran berhasil";
    }

    // --- 2. FUNGSI UNIT TEST (5 TEST CASE BERDASARKAN INDEPENDENT PATH) ---
    
    @Test
    public void testCase1_NamaKosong() {
        String hasil = validasiPendaftaran("", 20, "rekha@gmail.com", true);
        assertEquals("Nama harus diisi", hasil);
    }

    @Test
    public void testCase2_UmurKurangDari17() {
        String hasil = validasiPendaftaran("Rekha", 16, "rekha@gmail.com", true);
        assertEquals("Umur minimal 17 tahun", hasil);
    }

    @Test
    public void testCase3_EmailTidakValid() {
        String hasil = validasiPendaftaran("Rekha", 20, "rekhagmail.com", true);
        assertEquals("Email tidak valid", hasil);
    }

    @Test
    public void testCase4_TidakSetujuSyarat() {
        String hasil = validasiPendaftaran("Rekha", 20, "rekha@gmail.com", false);
        assertEquals("Harus menyetujui syarat dan ketentuan", hasil);
    }

    @Test
    public void testCase5_PendaftaranBerhasil() {
        String hasil = validasiPendaftaran("Rekha", 20, "rekha@gmail.com", true);
        assertEquals("Pendaftaran berhasil", hasil);
    }
}
