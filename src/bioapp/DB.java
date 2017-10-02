/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bioapp;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Haitham
 */
public class DB {

    public static DefaultTableModel getBioDbTableModel(
            String query,
            String desiredImpact)
            throws SQLException, ClassNotFoundException {
        Connection con = null;
        try {
            // Open DB connection
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(
                    "jdbc:mysql://68.169.56.150:3306/biodb", "biouser", "kalabala");
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            // Intialize your data structure
            Vector<Vector<Object>> data = new Vector<>();
            // Read row by row
            while (rs.next()) {
                // Store each value in a seperate variable with the 
                // corresponding data type.
                String breed = rs.getString(1); //assoc.breed (string)
                String var_type = rs.getString(2); //assoc.var_type (string)
                String chrom = rs.getString(3); //vcf_info.chrom (string)
                int pos = rs.getInt(4); //vcf_info.pos (int)
                String id = rs.getString(5); //vcf_info.id (string)
                String ref = rs.getString(6); //vcf_info.ref (string)
                String alt = rs.getString(7); //vcf_info.alt (string)
                float f_a = rs.getFloat(8); //assoc.f_a (float)
                float f_u = rs.getFloat(9); //assoc.f_u (float)
                float fdr = rs.getFloat(10); //assoc.fdr (float)
                int aff_alt = rs.getInt(11); //assoc.aff_alt (int)
                int aff_het = rs.getInt(12); //assoc.aff_het (int)
                int aff_ref = rs.getInt(13); //assoc.aff_ref (int)
                int unaff_alt = rs.getInt(14); //assoc.unaff_alt (int)
                int unaff_het = rs.getInt(15); //assoc.unaff_het (int)
                int unaff_ref = rs.getInt(16); //assoc.unaff_ref (int)
                String gene_name = rs.getString(17); //dog_ensembl.gene_name (string)
                String annDb = rs.getString(18); //var_effect.ann_db (int)
                String feature_name = rs.getString(19); //var_effect.feature_name (string)
                String feature_type = rs.getString(20); //var_effect.feature_type (string)
                String consequence = rs.getString(21); //var_effect.consequence (string)
                int cdna_pos = rs.getInt(22); //var_effect.cdna_position (int)
                int cds_pos = rs.getInt(23); //var_effect.cds_position (int)
                int protein_pos = rs.getInt(24); //var_effect.protein_position (int)
                String amino_acids = rs.getString(25); //var_effect.amino_acids (string)
                String codons = rs.getString(26); //var_effect.codons (string)
                String extra = rs.getString(27); //var_effect.extra (string)
                String assoc_gene_name = rs.getString(28); //dog_ensembl.associated_gene_name (string)
                String protein_coding = rs.getString(29); //dog_ensembl.protein_coding (string)
                String description = rs.getString(30); //dog_ensembl.description (string)
//                // Display current row
//                System.out.format(
//                        "%10s %10s %10s %5d %10s %10s %10s %10.5f %10.5f "
//                        + "%10.5f %5d %5d %5d %5d %5d %5d %10s %20s "
//                        + "%10s %20s %5d %5d %5d %40s %40s %10s %10s "
//                        + "%10s %10s%n",
//                        breed, var_type, chrom, pos, id, ref, alt, f_a, f_u,
//                        fdr, aff_alt, aff_het, aff_ref, unaff_alt, unaff_het,
//                        unaff_ref, gene_name, feature_name, feature_type,
//                        consequence, cdna_pos, cds_pos, protein_pos,
//                        amino_acids, codons, extra, assoc_gene_name,
//                        protein_coding, description);
                // Filter based on the impact (in the extra column)
                String[] splits = extra.split(";");
                String impact = splits[0].split("=")[1];
                if (desiredImpact.equalsIgnoreCase("any") || desiredImpact.equalsIgnoreCase(impact)) {
                    // Store all valules of the current row in a vector.
                    Vector row = new Vector<Object>();
                    row.add(breed);
                    row.add(var_type);
                    row.add(chrom);
                    row.add(pos);
                    row.add(id);
                    row.add(ref);
                    row.add(alt);
                    row.add(f_a);
                    row.add(f_u);
                    row.add(fdr);
                    row.add(aff_alt);
                    row.add(aff_het);
                    row.add(aff_ref);
                    row.add(unaff_alt);
                    row.add(unaff_het);
                    row.add(unaff_ref);
                    row.add(gene_name);
                    row.add(annDb);
                    row.add(feature_name);
                    row.add(feature_type);
                    row.add(consequence);
                    row.add(cdna_pos);
                    row.add(cds_pos);
                    row.add(protein_pos);
                    row.add(amino_acids);
                    row.add(codons);
                    row.add(extra);
                    row.add(assoc_gene_name);
                    row.add(protein_coding);
                    row.add(description);
                    // Append the current row to the main data structure.
                    data.add(row);
                }
            }
            // Columns names
            Vector<String> colNames = new Vector<>();
            /*
             * breed, var_type, chrom, pos, id, ref, alt, f_a, f_u, fdr,
             * aff_alt, aff_het, aff_ref, unaff_alt, unaff_het, unaff_ref,
             * gene_name, feature_name, feature_type, consequence, cdna_pos,
             * cds_pos, protein_pos, amino_acids, codons, extra,
             * assoc_gene_name, protein_coding, description
             */
            colNames.add("Breed");
            colNames.add("Var Type");
            colNames.add("Chromosome");
            colNames.add("Position");
            colNames.add("ID");
            colNames.add("Ref");
            colNames.add("Alt");
            colNames.add("Freq. Cases");
            colNames.add("Freq. Controls");
            colNames.add("FDR");
            colNames.add("Aff Alt");
            colNames.add("Aff Het");
            colNames.add("Aff Ref");
            colNames.add("Unaff Alt");
            colNames.add("Unaff Het");
            colNames.add("Unaff Ref");
            colNames.add("Gene");
            colNames.add("Annotation DB");
            colNames.add("Feature");
            colNames.add("Feature Type");
            colNames.add("Consequence");
            colNames.add("cDNA Pos");
            colNames.add("CDS Pos");
            colNames.add("Protein Pos");
            colNames.add("Amino Acids");
            colNames.add("Codons");
            colNames.add("Extra");
            colNames.add("Gene Name");
            colNames.add("Gene Biotype");
            colNames.add("Description");
            // Create the table model
            return new DefaultTableModel(data, colNames);
        } finally {
            if (con != null) {
                con.close();
            }
        }
    }
}
